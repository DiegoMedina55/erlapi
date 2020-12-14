package com.myerlang.erlapi.logic;
/*
 * Memebers:
 * @Author Gabriel Andres Avendaño Casadiego  gavendanoc@unal.edu.co
 * @Author Santiago Duque Bernal              saduquebe@unal.edu.co
 * @Author Juan Diego Medina Naranjo          jmedinan@unal.edu.co
 */
import com.myerlang.erlapi.gen.ErlangBaseVisitor;
import com.myerlang.erlapi.gen.ErlangParser;
import com.myerlang.erlapi.response.ResponseManager;
import com.myerlang.erlapi.response.StepToJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class MyVisitor<T> extends ErlangBaseVisitor {
    String startFunctionName = "start";
    Stack <Scope> scopes = new Stack<>();
    HashMap<String, ErlangFunction> functions = new HashMap<>();
    ResponseManager responseManager = new ResponseManager();
    StepToJson parser = new StepToJson(responseManager);
    boolean isAssignToVariable = false;
    boolean isGettingVariableName = false;
    boolean isGettingExported = false;
    int count = 0;
    /*
    @Override
    public Object visitForm(ErlangParser.FormContext ctx) {
        try {
            if(ctx.attribute().tokAtom().getText().equals("export")){
                String name = ctx.attribute().attrVal().expr().expr100().expr150(0).expr160(0).
                        expr200(0).expr300(0).expr400(0).expr500(0).expr600(0).
                        getText();
                System.out.println(name);
                int params = Integer.parseInt(ctx.attribute().attrVal().expr().expr100().expr150(0).expr160(0).
                        expr200(0).expr300(0).expr400(0).expr500(0).expr600(1).getText());
                responseManager.addFunction(name,params,true);
                System.out.println(params);
                ErlangParser.ExprsContext attribContext = ctx.attribute().attrVal().exprs();
                for(int i = 0; i < attribContext.expr().size(); i++){
                    String functionName = attribContext.expr(i).expr100().expr150(0).expr160(0).
                            expr200(0).expr300(0).expr400(0).expr500(0).expr600(0).
                            getText();
                    int functionParams = Integer.parseInt(attribContext.expr(i).expr100().expr150(0).
                            expr160(0).expr200(0).expr300(0).expr400(0).expr500(0).
                            expr600(1).getText());
                    System.out.println("Funcion: "+functionName+" Con cantidad de parametros: "+functionParams);
                    if(functions.get(functionName) != null){
                        responseManager.addFunction(functionName,functionParams,true);
                    }
                    else{
                        System.out.println("La función "+functionName+ " no existe");
                        String res = parser.ErrorToJson("Linea:"+ctx.start.getLine()+" Columna: "+ctx.start.getCharPositionInLine()+"La función "+functionName+ " no existe");
                        throw new ArrayIndexOutOfBoundsException(res);
                    }
                }
                //responseManager.addFunction()
                //System.out.println(ctx.attribute().attrVal().exprs().expr()getText());
            }
        }
        catch (Exception w){
            //No tienen atributos o no tienen export
        }
        return null;
    }
    */

    private void getExports(ErlangParser.FormsContext upperCtx) {
        ErlangParser.FormContext ctx= upperCtx.form().get(0);
        try {
            if(ctx.attribute().tokAtom().getText().equals("export")){
                String name = ctx.attribute().attrVal().expr().expr100().expr150(0).expr160(0).
                        expr200(0).expr300(0).expr400(0).expr500(0).expr600(0).
                        getText();
                int params = Integer.parseInt(ctx.attribute().attrVal().expr().expr100().expr150(0).expr160(0).
                        expr200(0).expr300(0).expr400(0).expr500(0).expr600(1).getText());
                lookup(name);
                int exists;
                ErlangParser.ExprsContext attribContext = ctx.attribute().attrVal().exprs();
                for(int i = 0; i < attribContext.expr().size(); i++){
                    String functionName = attribContext.expr(i).expr100().expr150(0).expr160(0).
                            expr200(0).expr300(0).expr400(0).expr500(0).expr600(0).
                            getText();
                    int functionParams = Integer.parseInt(attribContext.expr(i).expr100().expr150(0).
                            expr160(0).expr200(0).expr300(0).expr400(0).expr500(0).
                            expr600(1).getText());
                    if(functions.get(functionName) != null){
                        lookup(functionName);
                    }
                    else{
                        System.out.println("La función "+functionName+ " no existe");
                        String res = parser.ErrorToJson("Linea:"+ctx.start.getLine()+" Columna: "+ctx.start.getCharPositionInLine()+"La función "+functionName+ " no existe");
                        throw new ArrayIndexOutOfBoundsException(res);
                    }
                }
                //responseManager.addFunction()
                //System.out.println(ctx.attribute().attrVal().exprs().expr()getText());
            }
        }
        catch (Exception w){
            //No tienen atributos o no tienen export
        }
    }

    private void lookup(String name) {
        if(functions.get(name).getName().equals(name)){
            for (int i = 0;i< functions.size();i++){
                if(responseManager.getFunctions().get(i).getName().equals(name)){
                    responseManager.getFunctions().get(i).setExport(true);
                    break;
                }
            }
        }
    }

    @Override
    public Object visitAttribute(ErlangParser.AttributeContext ctx) {
        isGettingExported = true;
        Object res = super.visitAttribute(ctx);
        isGettingExported = false;
        return res;
    }

    @Override
    public T visitForms(ErlangParser.FormsContext ctx) {
        super.visitForms(ctx);
        getExports(ctx);
        // llamar a start()
        ErlangFunction start = functions.get(startFunctionName);
        if (start == null) {
            // Error: no se definio start
            System.out.println("Error: no se definio start");
            String res = parser.ErrorToJson("Linea:"+ctx.start.getLine()+" Columna: "+ctx.start.getCharPositionInLine()+" La función start no existe");
            throw new ArrayIndexOutOfBoundsException(res);
        }
        scopes.push(new Scope(startFunctionName)); // primer scope
        ErlangFunctionClause startClause = start.getClausesOfParams(0).get(0);

        //System.out.println(responseManager);

        Datatype init = (Datatype) visitClauseBody(startClause.getCtx().clauseBody());
        responseManager.buildStep(scopes,ctx.start.getLine(),"Paso inicial",init.getValue().toString());
        System.out.println(parser.StepsToJson());
        System.out.println(responseManager.getFunctions());
        return (T) parser.StepsToJson(); // devolver el analisis
    }



    @Override
    public T visitFunction(ErlangParser.FunctionContext ctx) {
        ErlangFunctionClause firstClause = (ErlangFunctionClause) visitFunctionClause(ctx.functionClause(0));
        String functionName = firstClause.getFunctionName();
        int params = firstClause.getNumParameters();
        ArrayList<ErlangFunctionClause> clauses = new ArrayList<>();
        clauses.add(firstClause);

        for (int i = 1; i < ctx.functionClause().size(); i++){
            ErlangFunctionClause clause = (ErlangFunctionClause) visitFunctionClause(ctx.functionClause(i));
            if (clause.getNumParameters() != params) {
                // Error: las clausulas deben tener mismo numero de params
                System.out.println("Error: las clausulas deben tener mismo numero de params");
                String res = parser.ErrorToJson("Linea:"+ctx.start.getLine()+" Columna: "+ctx.start.getCharPositionInLine()+" las clausulas deben tener mismo numero de params");
                throw new ArrayIndexOutOfBoundsException(res);
            }
            if (!clause.getFunctionName().equals(functionName)) {
                // Error: las clausulas deben tener mismo nombre
                System.out.println("Error: las clausulas deben tener mismo nombre");
                String res = parser.ErrorToJson("Linea:"+ctx.start.getLine()+" Columna: "+ctx.start.getCharPositionInLine()+" las clausulas deben tener mismo nombre");
                throw new ArrayIndexOutOfBoundsException(res);
            }
            clauses.add(clause);

        }

        ErlangFunction function = functions.get(functionName);
        if (function == null) { // funcion no existe aun
            function = new ErlangFunction(functionName);
            functions.put(functionName, function);
            responseManager.addFunction(functionName,params,false);
        }
        function.addClauses(params, clauses);
        return null;
    }

    @Override
    public T visitFunctionClause(ErlangParser.FunctionClauseContext ctx) {
        String functionName = ((Datatype) visitTokAtom(ctx.tokAtom())).getValue().toString();
        ErlangParser.ExprsContext exprs = ctx.clauseArgs().argumentList().exprs();
        int numParams = (exprs == null) ? 0 : exprs.expr().size();
        ErlangFunctionClause efc = new ErlangFunctionClause(functionName, numParams, ctx);
        return (T) efc;
    }

    @Override
    public T visitTokAtom(ErlangParser.TokAtomContext ctx) {
        Datatype dt = new Datatype(ctx.TokAtom().toString(), Datatype.Type.ATOM);
        return (T) dt;
    }

    @Override
    public Object visitTokString(ErlangParser.TokStringContext ctx) {
        Datatype dt = new Datatype(ctx.TokString().toString(), Datatype.Type.STRING);
        return (T) dt;
    }

    @Override
    public Object visitTokFloat(ErlangParser.TokFloatContext ctx) {
        Double number = Double.parseDouble(ctx.TokFloat().getText());
        Datatype dt = new Datatype(number, Datatype.Type.DOUBLE);
        return (T) dt;
    }

    @Override
    public Object visitTokInteger(ErlangParser.TokIntegerContext ctx) {
        Double number = Double.parseDouble(ctx.TokInteger().getText());
        Datatype dt = new Datatype(number, Datatype.Type.DOUBLE);
        return (T) dt;
    }

    @Override
    public T visitExpr100(ErlangParser.Expr100Context ctx) {
        if (ctx.expr150().size() == 1) {
            return (T) visitExpr150(ctx.expr150(0));
        }
        // Ejemplo N = 5;
        isAssignToVariable = true;
        // Objeto 'variable' en scope, actualizar aqui se actualiza el valor de la variable
        Datatype datatype = (Datatype) visitExpr150(ctx.expr150(0)); // N
        isAssignToVariable = false;
        Datatype value = (Datatype) visitExpr150(ctx.expr150(1)); // 4
        datatype.setType(value.getType());
        datatype.setValue(value.getValue()); // N = 4
        //Variable dentro de un scope
        System.out.println("Asignación de variables");
        responseManager.buildStep(scopes,ctx.start.getLine(),value.getValue().toString(),"");
        System.out.println(responseManager);
        return (T) value;
    }

    @Override
    public Object visitTokVar(ErlangParser.TokVarContext ctx) { // N + 4
        String variableName = ctx.TokVar().getText();
        if (isAssignToVariable) { // For assigning value
            if (this.scopes.peek().getScope().get(variableName) != null) {
                // Error, variable ya existe
                System.out.println("Error, variable ya existe");
                String res = parser.ErrorToJson("Linea:"+ctx.start.getLine()+" Columna: "+ctx.start.getCharPositionInLine()+" La variable ya existe");
                throw new ArrayIndexOutOfBoundsException(res);
            }
            Variable var = new Variable(variableName);
            this.scopes.peek().getScope().put(variableName, var);
            var.getDatatype().setValue("");
            return var.getDatatype();
        }
        if (isGettingVariableName) { // For pattern matching
            return new Datatype(variableName, Datatype.Type.VARIABLE_NAME);
        }
        if (this.scopes.peek().getScope().get(variableName) == null) {
            // Error: la variable no existe
            System.out.println("Error: La variable no existe");
            String res = parser.ErrorToJson("Linea:"+ctx.start.getLine()+" Columna: "+ctx.start.getCharPositionInLine()+" La variable no existe");
            throw new ArrayIndexOutOfBoundsException(res);
        }
        return this.scopes.peek().getScope().get(variableName).getDatatype(); // For getting value from variable
    }

    @Override
    public T visitFunctionCall(ErlangParser.FunctionCallContext ctx){
        //TODO: STEP
        responseManager.buildStep(scopes,ctx.start.getLine(),"","");
        if (ctx.PRINT() != null){
            return print(ctx);
        }
        String functionName = ((Datatype) visitExpr800(ctx.expr800())).getValue().toString();
        ErlangFunction erfunction = functions.get(functionName);
        if (erfunction == null) {
            // Error: Funcion no existe
            System.out.println("Error: Funcion no existe");
            String res = parser.ErrorToJson("Linea:"+ctx.start.getLine()+" Columna: "+ctx.start.getCharPositionInLine()+" La función no existe");
            throw new ArrayIndexOutOfBoundsException(res);
        }
        return patternMatching(ctx, erfunction);
    }

    public T print (ErlangParser.FunctionCallContext ctx) {
        //TODO: valor de retorno
        Datatype dt;
        if (ctx.expr() != null) {
            Datatype value = (Datatype) visitExpr(ctx.expr());
            //RETORNO DE OPERACIONES LOGICAS
            dt =new Datatype(value.getValue(), Datatype.Type.STRING);
            System.out.println(value.getValue());
            responseManager.buildStep(scopes,ctx.start.getLine(),String.valueOf(value.getValue()),"");
            count++;
            System.out.println("instrucción "+count+"  "+responseManager);
        }
        else{
            dt = new Datatype("ok", Datatype.Type.ATOM);
        }

        return (T) dt;
    }

    private T patternMatching (ErlangParser.FunctionCallContext callCtx , ErlangFunction function) {
        // System.out.println("patternMatching");
        ErlangParser.ExprsContext exprs = callCtx.argumentList().exprs();
        int parameters = exprs == null ? 0 : exprs.expr().size();
        ArrayList<ErlangFunctionClause> clauses = function.getClausesOfParams(parameters);

        if (clauses == null) {
            System.out.println("Error : No existe clausula con esa cantidad de parametros");
            String res = parser.ErrorToJson("Linea:"+callCtx.start.getLine()+" Columna: "+callCtx.start.getCharPositionInLine()+" No existe clausula con esa cantidad de parametros");
            throw new ArrayIndexOutOfBoundsException(res);
        }

        ArrayList<Datatype> parameterValues = new ArrayList<>();
        for (int i = 0; i < parameters ; i++) {
            parameterValues.add((Datatype) visitExpr(callCtx.argumentList().exprs().expr().get(i)));
        }

        int selected = 0;
        while(selected < clauses.size()) {
            ArrayList<Datatype> arguments = matchClauseWithCallingCtx(parameterValues, clauses.get(selected));
            if (arguments != null) {
                boolean check = true;
                if (clauses.get(selected).getCtx().clauseGuard().guard() != null) {
                    check = checkGuard(parameterValues, arguments, clauses.get(selected));
                }
                if (check) return callFunction(parameterValues, arguments, clauses.get(selected));
            }
            selected++;
        }
        System.out.println("Error : No se pudo hacer pattern matching");
        String res = parser.ErrorToJson("Linea:"+callCtx.start.getLine()+" Columna: "+callCtx.start.getCharPositionInLine()+" No se pudo hacer pattern matching");
        throw new ArrayIndexOutOfBoundsException(res);
    }

    private boolean checkGuard(ArrayList<Datatype> parameterValues, ArrayList<Datatype> arguments, ErlangFunctionClause clause){
        int parameters = parameterValues.size();
        String functionName = "temporalGuardScope";
        scopes.push(new Scope(functionName));
        // añadiendo los parametros al scope
        lookupParams(parameterValues, arguments, parameters);
        Datatype result = (Datatype) visitClauseGuard(clause.getCtx().clauseGuard());
        Boolean isOK = (Boolean) result.getValue();
        scopes.pop();
        return isOK;
    }
    //UTILS
    private void lookupParams(ArrayList<Datatype> parameterValues, ArrayList<Datatype> arguments, int parameters) {
        for (int i = 0; i < parameters; i++){
            if (arguments.get(i).isVariable()){
                String variableName = arguments.get(i).getValue().toString();
                Variable paramVariable = new Variable(variableName, true, parameterValues.get(i));
                scopes.peek().getScope().put(variableName, paramVariable);
            }
        }
    }

    private T callFunction(ArrayList<Datatype> parameterValues, ArrayList<Datatype> arguments, ErlangFunctionClause clause) {
        int parameters = parameterValues.size();
        scopes.push(new Scope(clause.getFunctionName()));
        // añadiendo los parametros al scope
        lookupParams(parameterValues, arguments, parameters);
        responseManager.buildStep(scopes, clause.getCtx().start.getLine(), null, null);
        Datatype result = (Datatype) visitClauseBody(clause.getCtx().clauseBody());
        //TODO: que es lo que hace el paso bien
        responseManager.buildStep(scopes, clause.getCtx().start.getLine(), null, result.getValue().toString());
        System.out.println("LLEGO:  "+result);
        System.out.println(responseManager);
        scopes.pop();
        //RETORNO Y OTRO PASO
        return (T) result;
    }

    @Override
    public Object visitClauseBody(ErlangParser.ClauseBodyContext ctx) throws NullPointerException{
        return visitExprs(ctx.exprs());
    }

    @Override
    public T visitExprs(ErlangParser.ExprsContext ctx) {
        try {
            for (int i = 0; i < ctx.expr().size() - 1; i++) {
                visitExpr(ctx.expr(i));
            }
            return (T) visitExpr(ctx.expr(ctx.expr().size() - 1));
        }
        catch (NullPointerException e){
            System.out.println("Efe");
        }
    return null;
    }

    private ArrayList<Datatype> matchClauseWithCallingCtx(ArrayList<Datatype> parameterValues, ErlangFunctionClause clause){
        int parameters = clause.getNumParameters();
        ArrayList<Datatype> arguments = new ArrayList<>();
        // System.out.println("matchClauseWithCallingCtx");
        for (int i = 0; i < parameters ; i++) {
            isGettingVariableName = true;
            Datatype argument = (Datatype) visitExpr(clause.getArguments().expr().get(i));
            isGettingVariableName = false;
            if (! argument.isVariable() && ! argument.equals(parameterValues.get(i))){
                return null;
            }
            arguments.add(argument);
        }
        return arguments;
    }

    @Override
    public T visitExpr200(ErlangParser.Expr200Context ctx) {
        if (ctx.compOp() == null) {
            return (T) visitExpr300(ctx.expr300(0));
        }
        String op = ctx.compOp().getText();
        Datatype dt1 = (Datatype) visitExpr300(ctx.expr300(0));
        Datatype dt2 = (Datatype) visitExpr300(ctx.expr300(1));
        // TODO: TAMBIEN SE PUEDEN HACER VERIFICACIONES AQUI, EN VEZ DE LA CLASE DATATYPE
        switch(op){
            case "==":
                return (T) dt1. equalop(dt2,ctx.start.getLine(),ctx.start.getCharPositionInLine());
            case ">=":
                return (T) dt1.greaterEqualOp(dt2,ctx.start.getLine(),ctx.start.getCharPositionInLine());
            case "=<":
                return (T) dt1.lessEqualOp(dt2,ctx.start.getLine(),ctx.start.getCharPositionInLine());
            case ">":
                return (T) dt1.greaterThanop(dt2,ctx.start.getLine(),ctx.start.getCharPositionInLine());
            case "<":
                return (T) dt1.lessThanop(dt2,ctx.start.getLine(),ctx.start.getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Object visitExpr400(ErlangParser.Expr400Context ctx) {
        Datatype result = (Datatype) visitExpr500(ctx.expr500(0));
        for (int i = 1; i < ctx.expr500().size() ; i++){
            Datatype other = (Datatype) visitExpr500(ctx.expr500(i));
            String op = ctx.addOp(i-1).getText();
            switch (op) {
                case "+":
                    result = result.arithmetic(other, "+",ctx.start.getLine(),ctx.start.getCharPositionInLine());
                    break;
                case "-":
                    result = result.arithmetic(other, "-",ctx.start.getLine(),ctx.start.getCharPositionInLine());
                    break;
            }
        }

        return (T) result;
    }
    @Override
    public Object visitExpr500(ErlangParser.Expr500Context ctx) {
        if(isGettingExported){
            return super.visitExpr500(ctx);
        }
        Datatype result = (Datatype) visitExpr600(ctx.expr600(0));

        for (int i = 1; i < ctx.expr600().size() ; i++){
            Datatype other = (Datatype) visitExpr600(ctx.expr600(i));
            String op = ctx.multOp(i-1).getText();
            switch (op) {
                case "*":
                    result = result.arithmetic(other, "*",ctx.start.getLine(),ctx.start.getCharPositionInLine());
                    break;
                case "/":
                    result = result.arithmetic(other, "/",ctx.start.getLine(),ctx.start.getCharPositionInLine());
                    break;
                case "rem":
                    result = result.arithmetic(other, "%",ctx.start.getLine(),ctx.start.getCharPositionInLine());
                    break;
            }
        }
        return (T) result;
    }
}

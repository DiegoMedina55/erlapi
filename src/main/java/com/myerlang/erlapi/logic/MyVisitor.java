package com.myerlang.erlapi.logic;
/**
 * Memebers:
 * @Author Gabriel Andres Avendaño Casadiego  gavendanoc@unal.edu.co
 * @Author Santiago Duque Bernal              saduquebe@unal.edu.co
 * @Author Juan Diego Medina Naranjo          jmedinan@unal.edu.co
 */
import com.myerlang.erlapi.gen.ErlangBaseVisitor;
import com.myerlang.erlapi.gen.ErlangParser;
import com.myerlang.erlapi.response.ResponseManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MyVisitor<T> extends ErlangBaseVisitor {
    String startFunctionName = "start";
    Stack <Scope> scopes = new Stack<>();
    HashMap<String, ErlangFunction> functions = new HashMap<>();
    ResponseManager responseManager = new ResponseManager();


    boolean isAssignToVariable = false;
    boolean isGettingVariableName = false;

    @Override
    public T visitForms(ErlangParser.FormsContext ctx) {
        super.visitForms(ctx);

        // llamar a start()
        ErlangFunction start = functions.get(startFunctionName);
        if (start == null) {
            // Error: no se definio start
            System.out.println("Error: no se definio start");
            System.exit(-1);
        }

        scopes.push(new Scope(startFunctionName)); // primer scope
        ErlangFunctionClause startClause = start.getClausesOfParams(0).get(0);
        visitClauseBody(startClause.getCtx().clauseBody());

        return null; // devolver el analisis
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
                System.exit(-1);
            }
            if (!clause.getFunctionName().equals(functionName)) {
                // Error: las clausulas deben tener mismo nombre
                System.out.println("Error: las clausulas deben tener mismo nombre");
                System.exit(-1);
            }
            clauses.add(clause);
        }

        ErlangFunction function = functions.get(functionName);
        if (function == null) { // funcion no existe aun
            function = new ErlangFunction(functionName);
            functions.put(functionName, function);
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
        return (T) value;
    }

    @Override
    public Object visitTokVar(ErlangParser.TokVarContext ctx) { // N + 4
        String variableName = ctx.TokVar().getText();
        if (isAssignToVariable) { // For assigning value
            if (this.scopes.peek().getScope().get(variableName) != null) {
                // Error, variable ya existe
                System.out.println("Error, variable ya existe");
                System.exit(-1);
            }
            Variable var = new Variable(variableName);
            this.scopes.peek().getScope().put(variableName, var);
            return var.getDatatype();
        }
        if (isGettingVariableName) { // For pattern matching
            return new Datatype(variableName, Datatype.Type.VARIABLE_NAME);
        }
        if (this.scopes.peek().getScope().get(variableName) == null) {
            // Error: la variable no existe
            System.out.println("Error: la variable no existe");
            System.exit(-1);
        }
        return this.scopes.peek().getScope().get(variableName).getDatatype(); // For getting value from variable
    }

    @Override
    public T visitFunctionCall(ErlangParser.FunctionCallContext ctx) {
        if (ctx.PRINT() != null){
            return print(ctx);
        }
        String functionName = ((Datatype) visitExpr800(ctx.expr800())).getValue().toString();
        ErlangFunction erfunction = functions.get(functionName);
        if (erfunction == null) {
            // Error: Funcion no existe
            System.out.println("Error: Funcion no existe");
            System.exit(-1);
        }
        return patternMatching(ctx, erfunction);
    }

    public T print (ErlangParser.FunctionCallContext ctx) {
        if (ctx.expr() != null) {
            Datatype value = (Datatype) visitExpr(ctx.expr());
            System.out.println(value.getValue());
        }
        Datatype dt = new Datatype("ok", Datatype.Type.ATOM);
        return (T) dt;
    }

    private T patternMatching (ErlangParser.FunctionCallContext callCtx , ErlangFunction function) {
        // System.out.println("patternMatching");
        ErlangParser.ExprsContext exprs = callCtx.argumentList().exprs();
        int parameters = exprs == null ? 0 : exprs.expr().size();
        ArrayList<ErlangFunctionClause> clauses = function.getClausesOfParams(parameters);

        if (clauses == null) {
            System.out.println("Error : No existe clausula con esa cantidad de parametros");
            System.exit(-1);
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
        System.out.println("Error : No se pudo hacer patterns matching");
        System.exit(-1);
        return null;
    }

    private boolean checkGuard(ArrayList<Datatype> parameterValues, ArrayList<Datatype> arguments, ErlangFunctionClause clause){
        int parameters = parameterValues.size();
        String functionName = "temporalGuardScope";
        scopes.push(new Scope(functionName));
        // añadiendo los parametros al scope
        for (int i = 0; i < parameters; i++){
            if (arguments.get(i).isVariable()){
                String variableName = arguments.get(i).getValue().toString();
                Variable paramVariable = new Variable(variableName, true, parameterValues.get(i));
                scopes.peek().getScope().put(variableName, paramVariable);
            }
        }
        Datatype result = (Datatype) visitClauseGuard(clause.getCtx().clauseGuard());
        Boolean isOK = (Boolean) result.getValue();
        scopes.pop();
        return isOK;
    }

    private T callFunction(ArrayList<Datatype> parameterValues, ArrayList<Datatype> arguments, ErlangFunctionClause clause) {
        int parameters = parameterValues.size();
        scopes.push(new Scope(clause.getFunctionName()));
        // añadiendo los parametros al scope
        for (int i = 0; i < parameters; i++){
            if (arguments.get(i).isVariable()){
                String variableName = arguments.get(i).getValue().toString();
                Variable paramVariable = new Variable(variableName, true, parameterValues.get(i));
                scopes.peek().getScope().put(variableName, paramVariable);
            }
        }
        Object result = visitClauseBody(clause.getCtx().clauseBody());
        responseManager.buildStep(scopes, null, null, null);
        scopes.pop();
        return (T) result;
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
                return (T) dt1. equalop(dt2);
            case ">=":
                return (T) dt1.greaterEqualOp(dt2);
            case "=<":
                return (T) dt1.lessEqualOp(dt2);
            case ">":
                return (T) dt1.greaterThanop(dt2);
            case "<":
                return (T) dt1.lessThanop(dt2);
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
                    result = result.arithmetic(other, "+");
                    break;
                case "-":
                    result = result.arithmetic(other, "-");
                    break;
            }
        }
        return (T) result;
    }
    @Override
    public Object visitExpr500(ErlangParser.Expr500Context ctx) {
        Datatype result = (Datatype) visitExpr600(ctx.expr600(0));

        for (int i = 1; i < ctx.expr600().size() ; i++){
            Datatype other = (Datatype) visitExpr600(ctx.expr600(i));
            String op = ctx.multOp(i-1).getText();
            switch (op) {
                case "*":
                    result = result.arithmetic(other, "*");
                    break;
                case "/":
                    result = result.arithmetic(other, "/");
                    break;
                case "rem":
                    result = result.arithmetic(other, "%");
                    break;
            }
        }
        return (T) result;
    }
}

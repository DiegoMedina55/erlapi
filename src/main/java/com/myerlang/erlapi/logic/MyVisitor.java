package com.myerlang.erlapi.logic; /**
 * Memebers:
 * @Author Gabriel Andres Avendaño Casadiego  gavendanoc@unal.edu.co
 * @Author Santiago Duque Bernal              saduquebe@unal.edu.co
 * @Author Juan Diego Medina Naranjo          jmedinan@unal.edu.co
 */
import com.myerlang.erlapi.gen.ErlangBaseVisitor;
import com.myerlang.erlapi.gen.ErlangParser;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class MyVisitor<T> extends ErlangBaseVisitor {
    String startFunctionName = "start";
    Stack <HashMap<String, Object>> scopes = new Stack<>();
    HashMap<String, ErlangFunction> functions = new HashMap<>();

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

        scopes.push(new HashMap<String, Object>()); // primer scope
        ErlangFunctionClause startClause = start.getClausesOfParams(0).get(0);
        visitClauseBody(startClause.getCtx().clauseBody());
        return null;
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
        Datatype variable = (Datatype) visitExpr150(ctx.expr150(0));
        isAssignToVariable = false;
        Datatype value = (Datatype) visitExpr150(ctx.expr150(1));
        variable.setType(value.getType());
        variable.setValue(value.getValue());
        return (T) value;
    }

    @Override
    public Object visitTokVar(ErlangParser.TokVarContext ctx) {
        String variableName = ctx.TokVar().getText();
        if (isAssignToVariable) { // For assigning value
            if (this.scopes.peek().get(variableName) != null) {
                // Error, variable ya existe
            }
            Datatype emptyDataType = new Datatype();
            this.scopes.peek().put(variableName, emptyDataType);
            return emptyDataType;
        }
        if (isGettingVariableName) { // For pattern matching
            return new Datatype(variableName, Datatype.Type.VARIABLE_NAME);
        }
        if (this.scopes.peek().get(variableName) == null) {
            // Error: la variable no existe
            System.out.println("Error: la variable no existe");
            System.exit(-1);
        }
        return this.scopes.peek().get(variableName); // For getting value from variable
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
        System.out.println("patternMatching");
        int parameters = callCtx.argumentList().exprs().expr().size();
        ArrayList<ErlangFunctionClause> clauses = function.getClausesOfParams(parameters);
        System.out.println(function.getAllClauses());

        if (clauses == null) {
            System.out.println("Error : No existe clausula con esa cantidad de parametros");
            System.exit(-1);
        }

        ArrayList<Datatype> parameterValues = new ArrayList<>();
        for (int i = 0; i < parameters ; i++) {
            parameterValues.add((Datatype) visitExpr(callCtx.argumentList().exprs().expr().get(i)));
        }

        int selected = 0;
        ArrayList<Datatype> arguments = matchClauseWithCallingCtx(parameterValues, clauses.get(selected));
        while(arguments == null) {
            selected++;
            if (selected >= clauses.size()){
                System.out.println("Error : No se pudo hacer patterns matching");
                System.exit(-1);
            }
            arguments = matchClauseWithCallingCtx(parameterValues, clauses.get(selected));
        }
        return callFunction(parameterValues, arguments, clauses.get(selected));
    }

    private T callFunction(ArrayList<Datatype> parameterValues, ArrayList<Datatype> arguments, ErlangFunctionClause clause) {
        int parameters = parameterValues.size();
        scopes.push(new HashMap<String, Object>());
        // añadiendo los parametros al scope
        for (int i = 0; i < parameters; i++){
            if (arguments.get(i).isVariable()){
                String variableName = arguments.get(i).getValue().toString();
                scopes.peek().put(variableName, parameterValues.get(i));
            }
        }
        Object result = visitClauseBody(clause.getCtx().clauseBody());
        scopes.pop();
        return (T) result;
        /*
        // revisar si la cantidad de parametros es correcta
        if (parameters != ctxFc.lexpr().size()){
            String name = ctxFn.FID().getText();
            int line = ctxFc.FID().getSymbol().getLine();
            int col = ctxFc.FID().getSymbol().getCharPositionInLine() + 1;
            System.err.printf("<%d:%d> Error semántico, los parametros dados a la funcion: " + name + " no corresponden con su declaracion.",line,col);
            System.exit(-1);
        }

        // Retornar si el statement vacio
        if (ctxFn.stmt_block() == null) {
            return (T) (Double) 0.0;
        }

        ArrayList<T> parameterValues = new ArrayList<>();
        for (int i = 0; i < parameters; i++){
            parameterValues.add(visitLexpr(ctxFc.lexpr(i)));
        }

        scopes.push(new HashMap<String, Object>());
        // añadiendo parametros al scope
        for (int i = 0; i < parameters; i++){
            String paramName = ctxFn.PARAMS.ID(i).getText();
            T value = parameterValues.get(i);
            Datatype type = new Datatype();
            if (ctxFn.PARAMS.DATATYPE(i).getText().equals("num")) {
                type.setType(Datatype.Type.DOUBLE);
            } else {
                type.setType(Datatype.Type.BOOLEAN);
            }
            type.setValue(value);
            scopes.peek().put(paramName, type);
        }
        if (ctxFn.LOCAL_VAR != null) visitVar_decl(ctxFn.LOCAL_VAR);
        T result = visitStmt_block(ctxFn.stmt_block());
        if (result == null){
            result = (T) (Double) 0.0; // si no hay resultado, se retorna el default
        }
        scopes.pop();
        return result;*/
    }

    private ArrayList<Datatype> matchClauseWithCallingCtx(ArrayList<Datatype> parameterValues, ErlangFunctionClause clause){
        int parameters = clause.getNumParameters();
        ArrayList<Datatype> arguments = new ArrayList<>();
        System.out.println("matchClauseWithCallingCtx");
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

    /**
    @Override
    public T visitProg(BccLanguageParser.ProgContext ctx) {
        scopes.push(new HashMap<String, Object>());
        for (int i = 0; i < ctx.fn_decl_list().size(); i++) {
            visitFn_decl_list(ctx.fn_decl_list(i));
        }
        visitMain_prog(ctx.main_prog());
        return (T) printing;
    }

    @Override
    public T visitVar_decl(BccLanguageParser.Var_declContext ctx) {
        for (int i = 0; i < ctx.ID().size(); i++) {
            String name = ctx.ID(i).getText();
            if (scopes.peek().get(name) != null) {
                int line = ctx.ID(i).getSymbol().getLine();
                int col = ctx.ID(i).getSymbol().getCharPositionInLine() + 1;
                System.err.printf("<%d:%d> Error semántico, la variable con nombre: " + name + " ya ha sido declarada.", line, col);
                System.exit(-1);
            }else{
                Datatype type = new Datatype();
                if (ctx.DATATYPE(i).getText().equals("num")) {
                    type.setType(Datatype.Type.DOUBLE);
                    type.setValue(0.0);
                } else {
                    type.setType(Datatype.Type.BOOLEAN);
                    type.setValue(true);
                }
                scopes.peek().put(name, type);
            }
        }
        return null;
    }

    @Override
    public T visitFn_decl_list(BccLanguageParser.Fn_decl_listContext ctx) {
        functions.put(ctx.FID().getText(), ctx);
        return null;
    }

    @Override
    public T visitStmt_block(BccLanguageParser.Stmt_blockContext ctx) {
        int stmtSize = ctx.stmt().size();
        for (int i = 0; i < stmtSize; i++) {
            T result = visitStmt(ctx.stmt(i));
            if(tk_next || tk_break || result != null){
                tk_next = false;
                return result;
            }
        }
        return null;
    }

    @Override
    public T visitStmt(BccLanguageParser.StmtContext ctx) {

        if (ctx.PRINT() != null) {
            String toPrint = visitLexpr(ctx.lexpr(0)).toString();
            printing += toPrint + "\n";
        } else if (ctx.INPUT() != null) {
            Scanner scan = new Scanner(System.in);
            String id = ctx.ID().getSymbol().getText();
            if (scopes.peek().containsKey(id)) {
                System.out.println("Se va a reemplazar el valor de: " + id);
                if ((Double) scopes.peek().get(id) == 0.0) {
                    scopes.peek().replace(id, scan.nextDouble());
                } else {
                    scopes.peek().replace(id, scan.nextBoolean());
                }
            }
        } else if (ctx.WHEN() != null) {
            if (Utils.castToBoolean(visitLexpr(ctx.lexpr(0)))) {
                return visitStmt_block(ctx.stmt_block(0));
            }
        } else if (ctx.IF() != null) {
            if (Utils.castToBoolean(visitLexpr(ctx.lexpr(0)))) {
                return visitStmt_block(ctx.stmt_block(0));
            } else {
                return visitStmt_block(ctx.stmt_block(1));
            }
        } else if (ctx.UNLESS() != null) {
            if (!Utils.castToBoolean(visitLexpr(ctx.lexpr(0)))) {
                return visitStmt_block(ctx.stmt_block(0));
            }
        } else if (ctx.ALONEWHILE != null) {
            while (Utils.castToBoolean(visitLexpr(ctx.lexpr(0)))) {
                T result = visitStmt_block(ctx.stmt_block(0));
                if (tk_break || result != null) {
                    tk_break = false;
                    return result;
                }
            }
        } else if (ctx.RETURN() != null) {
            return visitLexpr(ctx.lexpr(0));
        } else if (ctx.ALONEUNTIL != null) {
            while (!Utils.castToBoolean(visitLexpr(ctx.lexpr(0)))) {
                T result = visitStmt_block(ctx.stmt_block(0));
                if (tk_break || result != null) {
                    tk_break = false;
                    return result;
                }
            }
        } else if (ctx.LOOP() != null) {
            while(true){
                T result = visitStmt_block(ctx.stmt_block(0));
                if (tk_break || result != null) {
                    tk_break = false;
                    return result;
                }
            }
        } else if (ctx.DOWHILE != null) {
            do {
                T result = visitStmt_block(ctx.stmt_block(0));
                if (tk_break || result != null) {
                    tk_break = false;
                    return result;
                }
            } while ((Boolean)visitLexpr(ctx.lexpr(0)));
        } else if (ctx.DOUNTIL != null) {
            do {
                T result = visitStmt_block(ctx.stmt_block(0));
                if (tk_break || result != null) {
                    tk_break = false;
                    return result;
                }
            } while (!Utils.castToBoolean(visitLexpr(ctx.lexpr(0))));
        } else if (ctx.REPEAT() != null) {
            //repetir un bloque un número de veces?
            int iterator = Integer.parseInt(ctx.NUM().getSymbol().getText());
            for (int i = 0; i < iterator; i++) {
                T result = visitStmt_block(ctx.stmt_block(0));
                if (tk_break || result != null) {
                    tk_break = false;
                    return result;
                }

            }
        }
        else if(ctx.FOR() != null){
            for (visitLexpr(ctx.lexpr(0)); Utils.castToBoolean(visitLexpr(ctx.lexpr(1))); visitLexpr(ctx.lexpr(2))){ //?
                visitStmt_block(ctx.stmt_block(0));
                if (tk_break) {
                    tk_break = false;
                    break;
                }
            }
        }
        else if (ctx.NEXT() != null) {
            tk_next = true;
        } else if (ctx.BREAK() != null) {
            tk_break = true;
        }
        else if(ctx.ASSIGNOP() != null){
            T result = visitLexpr(ctx.lexpr(0));
            String name = ctx.ID().getText();
            if (scopes.peek().get(name) == null){
                int line = ctx.ID().getSymbol().getLine();
                int col = ctx.ID().getSymbol().getCharPositionInLine() + 1;
                System.err.printf("<%d:%d> Error semántico, la variable con nombre: " +name + " no ha sido declarada.",line,col);
                System.exit(-1);
            }

            String op = ctx.ASSIGNOP().getText();
            Datatype var = (Datatype) scopes.peek().get(name);
            switch (op){
                case ":=":
                    var.setValue(result);
                    break;
                case "+=":
                    if (var.getType() == Datatype.Type.DOUBLE)
                        var.setValue( (Double) var.getValue() + Utils.castToDouble(result));
                    else
                        var.setValue( Utils.castToDouble(var.getValue()) + Utils.castToDouble(result));
                    break;
                case "-=":
                    if (var.getType() == Datatype.Type.DOUBLE)
                        var.setValue( (Double) var.getValue() - Utils.castToDouble(result));
                    else
                        var.setValue( Utils.castToDouble(var.getValue()) - Utils.castToDouble(result));
                    break;
                case "*=":
                    if (var.getType() == Datatype.Type.DOUBLE)
                        var.setValue( (Double) var.getValue() * Utils.castToDouble(result));
                    else
                        var.setValue( Utils.castToDouble(var.getValue()) * Utils.castToDouble(result));
                    break;
                case "/=":
                    if (var.getType() == Datatype.Type.DOUBLE){
                        if((Double)result == 0.0){
                            System.out.println("Error semantico. No se puede dividir por 0");
                            System.exit(-1);
                        }
                        var.setValue( (Double) var.getValue() / Utils.castToDouble(result));}
                    else
                        var.setValue( Utils.castToDouble(var.getValue()) / Utils.castToDouble(result));
                    break;
                case "%=":
                    if (var.getType() == Datatype.Type.DOUBLE){
                        if((Double)result == 0.0){
                            System.out.println("Error semantico. No se puede sacar modulo con 0");
                            System.exit(-1);
                        }
                        var.setValue( (Double) var.getValue() % Utils.castToDouble(result));}
                    else
                        var.setValue( Utils.castToDouble(var.getValue()) % Utils.castToDouble(result));
                    break;

            }
        }
        else if (ctx.RIGHT_INC != null || ctx.RIGHT_DEC != null || ctx.LEFT_INC != null || ctx.LEFT_DEC != null) {
            String name = ctx.ID().getText();
            if (scopes.peek().get(name) == null) {
                int line = ctx.ID().getSymbol().getLine();
                int col = ctx.ID().getSymbol().getCharPositionInLine() + 1;
                System.err.printf("<%d:%d> Error semantico, la variable con nombre: \"" + name + "\" no ha sido declarada.\n", line, col);
                System.exit(-1);
            }
            Datatype var = (Datatype) scopes.peek().get(name);
            Double id = (Double) var.getValue();
            if (ctx.RIGHT_INC != null || ctx.LEFT_INC != null) {
                var.setValue(id + 1);
            } else {
                var.setValue(id - 1);
            }
        }
        return null;
    }

    @Override
    public T visitLexpr(BccLanguageParser.LexprContext ctx){
        if (ctx.nexpr().size() == 1) {
            return visitNexpr(ctx.nexpr(0));
        }

        boolean result = Utils.castToBoolean(visitNexpr(ctx.nexpr(0)));

        if (ctx.AND().size() != 0) {
            for (int i = 0; i < ctx.AND().size(); i++){
                boolean nexpr = Utils.castToBoolean(visitNexpr(ctx.nexpr(i + 1)));
                result = result && nexpr;
            }

            return (T) (Boolean) result;
        }

        for (int i = 0; i < ctx.OR().size(); i++){
            boolean nexpr = Utils.castToBoolean(visitNexpr(ctx.nexpr(i + 1)));
            result = result || nexpr;
        }
        return (T) (Boolean) result;
    }

    @Override
    public T visitNexpr(BccLanguageParser.NexprContext ctx){
        if(ctx.NOT() != null) {
            Boolean result = ! Utils.castToBoolean( visitLexpr(ctx.lexpr()));
            return (T) result;
        };
        return visitRexpr(ctx.rexpr());
    }

    @Override
    public T visitRexpr(BccLanguageParser.RexprContext ctx){
        if (ctx.simple_expr().size() == 1) {
            return (T) visitSimple_expr(ctx.simple_expr(0));
        }

        Double simple_expr1 = Utils.castToDouble(visitSimple_expr(ctx.simple_expr(0)));
        Double simple_expr2 = Utils.castToDouble(visitSimple_expr(ctx.simple_expr(1)));
        String op = ctx.COMPARISONOP().getText();

        switch (op) {
            case "<":
                return (T) (Boolean) (simple_expr1 < simple_expr2);
            case "==":
                return (T) (Boolean) (simple_expr1.equals(simple_expr2));
            case "<=":
                return (T) (Boolean) (simple_expr1 <= simple_expr2);
            case ">":
                return (T) (Boolean) (simple_expr1 > simple_expr2);
            case ">=":
                return (T) (Boolean) (simple_expr1 >= simple_expr2);
            case "!=":
                return (T) (Boolean) (!simple_expr1.equals(simple_expr2));
        }
        return null;
    }

    @Override
    public T visitSimple_expr(BccLanguageParser.Simple_exprContext ctx){
        if (ctx.term().size() == 1) {
            return visitTerm(ctx.term(0)); // puede ser un bool o un numero
        }

        // Debe ser un numero
        Double total = Utils.castToDouble(visitTerm(ctx.term(0)));
        for (int i = 1 ; i < ctx.term().size() ; i++){
            Double term = Utils.castToDouble(visitTerm(ctx.term(i)));
            String op = ctx.SUMOP(i - 1).getText();
            switch (op) {
                case "+":
                    total += term;
                    break;
                case "-":
                    total -= term;
                    break;
            }
        }
        return (T) total;
    }

    @Override
    public T visitTerm(BccLanguageParser.TermContext ctx) {
        if (ctx.factor().size() == 1) return visitFactor(ctx.factor(0));

        Double answer = Utils.castToDouble(visitFactor(ctx.factor(0)));
        for(int i =1;i<ctx.factor().size();i++){
            try {
                Double fi = Utils.castToDouble(visitFactor(ctx.factor(i)));
                switch (ctx.MULOP(i - 1).getText()) {
                    case "/":
                        if(fi == 0.0){
                            System.out.println("Error semantico. No se puede dividir por 0");
                            System.exit(-1);
                        }
                        answer /= fi;
                        break;
                    case "*":
                        answer *= fi;
                        break;
                    case "%":
                        answer %= fi;
                        break;
                }
            } catch (Exception e) { // Error: Uno de los factores(Bool o ID) no es numero
                int line = ctx.factor(i).NUM().getSymbol().getLine();
                int col = ctx.factor(i).NUM().getSymbol().getCharPositionInLine() + 1;
                if (ctx.factor(i).BOOL() != null) {
                    String symbol = ctx.factor(i).BOOL().getSymbol().getText();
                    System.err.printf("<%d:%d> Error semántico, " + symbol + " no es un símbolo válido para una para la operación.", line, col);
                } else {
                    String varName = ctx.factor(i).ID().getSymbol().getText();
                    System.err.printf("<%d:%d> Error semántico, el valor la variable " + varName + " no es válido para la operación.", line, col);
                }
                System.exit(-1);
            }
        }
        return (T) answer;
    }

    @Override
    public T visitFactor(BccLanguageParser.FactorContext ctx) {
        if (ctx.NUM() != null) {
            return (T) (Double) Double.parseDouble(ctx.NUM().getText());
        }
        if (ctx.BOOL() != null) {
            return (T) (Boolean) ctx.BOOL().getText().equals("true");
        }
        if (ctx.RIGHT_INC != null || ctx.RIGHT_DEC != null || ctx.LEFT_INC != null || ctx.LEFT_DEC != null) {
            String name = ctx.ID().getText();
            if (scopes.peek().get(name) == null) {
                int line = ctx.ID().getSymbol().getLine();
                int col = ctx.ID().getSymbol().getCharPositionInLine() + 1;
                System.err.printf("<%d:%d> Error semantico, la variable con nombre: \"" + name + "\" no ha sido declarada.\n", line, col);
                System.exit(-1);
            }
            Datatype var = (Datatype) scopes.peek().get(name);
            Double id = (Double) var.getValue();
            if (ctx.RIGHT_INC != null || ctx.LEFT_INC != null) {
                var.setValue(id + 1);
            } else {
                var.setValue(id - 1);
            }

            if (ctx.RIGHT_INC != null || ctx.RIGHT_DEC != null) {
                return (T) id;
            }
            return (T) var.getValue();
        }
        if (ctx.ID() != null) {
            String name = ctx.ID().getText();
            if (scopes.peek().get(name) == null) {
                int line = ctx.ID().getSymbol().getLine();
                int col = ctx.ID().getSymbol().getCharPositionInLine() + 1;
                System.err.printf("<%d:%d> Error semantico, la variable con nombre: \"" + name + "\" no ha sido declarada.\n", line, col);
                System.exit(-1);
            }

            Datatype var = (Datatype) scopes.peek().get(name);
            return (T) var.getValue();
        }
        if (ctx.ALONE_EXPR != null) {
            return (T) visitLexpr(ctx.lexpr(0));
        }
        if (ctx.FID() != null) {
            String name = ctx.FID().getText();
            if(functions.get(name) == null) {
                int line = ctx.FID().getSymbol().getLine();
                int col = ctx.FID().getSymbol().getCharPositionInLine() + 1;
                System.err.printf("<%d:%d> Error semántico, la funcion con nombre: " + name + " no ha sido declarada.",line,col);
                System.exit(-1);
            }
            T result = callFunction(functions.get(name), ctx);
            if (functions.get(name).DATATYPE().getText().equals("num")) {
                return (T) Utils.castToDouble(result);
            }
            return (T) Utils.castToBoolean(result);
        }
        return null;
    }

    @Override
    public T visitMain_prog(BccLanguageParser.Main_progContext ctx) {
        if (ctx.VAR() != null) {
            visitVar_decl(ctx.var_decl());
        }
        if (ctx.stmt() != null) {
            for (int i = 0; i < ctx.stmt().size(); i++) {
                visitStmt(ctx.stmt(i));
            }
        }
        return null; // como saber que ya acabo?
    }

    private T callFunction(BccLanguageParser.Fn_decl_listContext ctxFn, BccLanguageParser.FactorContext ctxFc) {
        int parameters = ctxFn.PARAMS.DATATYPE().size();

        // revisar si la cantidad de parametros es correcta
        if (parameters != ctxFc.lexpr().size()){
            String name = ctxFn.FID().getText();
            int line = ctxFc.FID().getSymbol().getLine();
            int col = ctxFc.FID().getSymbol().getCharPositionInLine() + 1;
            System.err.printf("<%d:%d> Error semántico, los parametros dados a la funcion: " + name + " no corresponden con su declaracion.",line,col);
            System.exit(-1);
        }

        // Retornar si el statement vacio
        if (ctxFn.stmt_block() == null) {
            return (T) (Double) 0.0;
        }

        ArrayList<T> parameterValues = new ArrayList<>();
        for (int i = 0; i < parameters; i++){
            parameterValues.add(visitLexpr(ctxFc.lexpr(i)));
        }

        scopes.push(new HashMap<String, Object>());
        // añadiendo parametros al scope
        for (int i = 0; i < parameters; i++){
            String paramName = ctxFn.PARAMS.ID(i).getText();
            T value = parameterValues.get(i);
            Datatype type = new Datatype();
            if (ctxFn.PARAMS.DATATYPE(i).getText().equals("num")) {
                type.setType(Datatype.Type.DOUBLE);
            } else {
                type.setType(Datatype.Type.BOOLEAN);
            }
            type.setValue(value);
            scopes.peek().put(paramName, type);
        }
        if (ctxFn.LOCAL_VAR != null) visitVar_decl(ctxFn.LOCAL_VAR);
        T result = visitStmt_block(ctxFn.stmt_block());
        if (result == null){
            result = (T) (Double) 0.0; // si no hay resultado, se retorna el default
        }
        scopes.pop();
        return result;
    }
    **/
}

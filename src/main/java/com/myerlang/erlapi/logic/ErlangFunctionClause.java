package com.myerlang.erlapi.logic;

/**
 * Almacena el contexto de una sola declaracion de funcion
 *
 * Por ejemplo:
 * Se tiene la clausula : sum(a, b) -> a + b.
 *
 * Entonces
 * functionName = sum
 * numParameters = 2
 * ctx = Contexto de clausula [sum(a, b) -> a + b]
 *
 *
 */

import com.myerlang.erlapi.gen.ErlangParser;

import java.util.List;

public class ErlangFunctionClause {
    String functionName;
    Integer numParameters;
    ErlangParser.FunctionClauseContext ctx;
    ErlangParser.ExprsContext arguments;

    public ErlangFunctionClause(String functionName, Integer numParameters, ErlangParser.FunctionClauseContext ctx) {
        this.functionName = functionName;
        this.numParameters = numParameters;
        this.ctx = ctx;
        this.arguments = ctx.clauseArgs().argumentList().exprs();

    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Integer getNumParameters() {
        return numParameters;
    }

    public void setNumParameters(Integer numParameters) {
        this.numParameters = numParameters;
    }

    public ErlangParser.FunctionClauseContext getCtx() {
        return ctx;
    }

    public void setCtx(ErlangParser.FunctionClauseContext ctx) {
        this.ctx = ctx;
    }

    public ErlangParser.ExprsContext getArguments() {
        return arguments;
    }
}

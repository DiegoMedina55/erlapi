package com.myerlang.erlapi.logic;

import java.util.HashMap;

public class Scope {
    private String functionName;
    private HashMap<String, Variable> scope = new HashMap<>();

    public Scope (String functionName){
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public HashMap<String, Variable> getScope() {
        return scope;
    }

    public void setScope(HashMap<String, Variable> scope) {
        this.scope = scope;
    }
}

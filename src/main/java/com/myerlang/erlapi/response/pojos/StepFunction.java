package com.myerlang.erlapi.response.pojos;

import java.util.HashMap;

public class StepFunction {
    String name;
    HashMap<String, String> params;
    HashMap<String, String> variables;
    HashMap<String, String> objectVariales;
    String returnValue;

    public StepFunction(String name, HashMap<String, String> params, HashMap<String, String> variables, HashMap<String, String> objectVariales, String returnValue) {
        this.name = name;
        this.params = params;
        this.variables = variables;
        this.objectVariales = objectVariales;
        this.returnValue = returnValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    public HashMap<String, String> getVariables() {
        return variables;
    }

    public void setVariables(HashMap<String, String> variables) {
        this.variables = variables;
    }

    public HashMap<String, String> getObjectVariales() {
        return objectVariales;
    }

    public void setObjectVariales(HashMap<String, String> objectVariales) {
        this.objectVariales = objectVariales;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    @Override
    public String toString() {
        return "StepFunction{" +
                "name='" + name + '\'' +
                ", params=" + params +
                ", variables=" + variables +
                ", objectVariales=" + objectVariales +
                ", returnValue='" + returnValue + '\'' +
                '}';
    }
}

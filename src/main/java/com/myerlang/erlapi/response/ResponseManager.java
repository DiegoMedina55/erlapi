package com.myerlang.erlapi.response;

import com.myerlang.erlapi.logic.Scope;
import com.myerlang.erlapi.logic.Variable;

import java.util.*;

public class ResponseManager {
    ArrayList<Step> steps = new ArrayList<Step>();

    public Step buildStep (Stack<Scope> scopes, Integer currentLine, String output, String returnValue) {
        ArrayList<StepFunction> functions = new ArrayList<>();
        for (int i = 0; i < scopes.size(); i++){
            Scope scope = scopes.get(i);
            String name = scope.getFunctionName();
            HashMap<String, String> params = getParams(scope.getScope());
            HashMap<String, String> variables = getVariables(scope.getScope());
            HashMap<String, String> objectVariales = getObjectVariables(scope.getScope());

            String returnVal = (i == scopes.size() - 1) ? returnValue : null;
            functions.add(new StepFunction(name, params, variables, objectVariales, returnVal));

            System.out.println("scope " + i);
            System.out.println(name);
            System.out.println(params);
            System.out.println(variables);
            System.out.println(objectVariales);
        }
        return new Step(currentLine, null, output, null, functions);
    }

    private HashMap<String, String> getParams(HashMap<String, Variable> localScope){
        HashMap<String, String> params = new HashMap<>();
        Iterator hmIterator = localScope.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            Variable var = (Variable) mapElement.getValue();
            if (var.isParam()) {
                if (var.getDatatype().isObject()) {
                    params.put(var.getName(), var.getDatatype().getObjectId());
                } else {
                    params.put(var.getName(), var.getDatatype().getValue().toString());
                }
            }
        }
        return params;
    }

    private HashMap<String, String> getVariables (HashMap<String, Variable> localScope){
        HashMap<String, String> variables = new HashMap<>();
        Iterator hmIterator = localScope.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            Variable var = (Variable) mapElement.getValue();
            if (!var.isParam() && !var.getDatatype().isObject()) {
                variables.put(var.getName(), var.getDatatype().getValue().toString());
            }
        }
        return variables;
    }

    private HashMap<String, String> getObjectVariables (HashMap<String, Variable> localScope){
        HashMap<String, String> variables = new HashMap<>();
        Iterator hmIterator = localScope.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            Variable var = (Variable) mapElement.getValue();
            if (var.getDatatype().isObject()) {
                variables.put(var.getName(), var.getDatatype().getObjectId());
            }
        }
        return variables;
    }
}

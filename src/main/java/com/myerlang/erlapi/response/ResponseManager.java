package com.myerlang.erlapi.response;

import com.myerlang.erlapi.logic.Datatype;
import com.myerlang.erlapi.logic.ListObject;
import com.myerlang.erlapi.logic.Scope;
import com.myerlang.erlapi.logic.Variable;
import com.myerlang.erlapi.response.pojos.FunctionDeclaration;
import com.myerlang.erlapi.response.pojos.Step;
import com.myerlang.erlapi.response.pojos.StepFunction;

import java.util.*;

public class ResponseManager {
    ArrayList<FunctionDeclaration> functions = new ArrayList<FunctionDeclaration>();
    ArrayList<Step> steps = new ArrayList<Step>();

    public Step buildStep (Stack<Scope> scopes, Integer currentLine, String output, String returnValue) {
        ArrayList<StepFunction> functions = new ArrayList<>();
        for (int i = 0; i < scopes.size(); i++){
            Scope scope = scopes.get(i);
            String name = scope.getFunctionName();
            HashMap<String, String> params = getParams(scope.getScope());
            HashMap<String, String> variables = getVariables(scope.getScope());
            HashMap<String, String> objectVariables = getObjectVariables(scope.getScope());

            String returnVal = (i == scopes.size() - 1) ? returnValue : null;
            functions.add(new StepFunction(name, params, variables, objectVariables, returnVal));
            /*
            System.out.println("scope " + i);
            System.out.println(name);
            System.out.println(params);
            System.out.println(variables);
            System.out.println(objectVariables);*/
        }
        Step step = new Step(currentLine, null, output, null, functions);
        steps.add(step);
        return step;
    }

    private HashMap<String, String> getParams(HashMap<String, Variable> localScope){
        HashMap<String, String> params = new HashMap<>();
        Iterator hmIterator = localScope.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            Variable var = (Variable) mapElement.getValue();
            if (var.isParam()) {
                if (var.getDatatype().getType() == Datatype.Type.LIST) {
                    params.put(var.getName(), ((ListObject) var.getDatatype().getValue()).getListId());
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
            if (!var.isParam() && var.getDatatype().getType() != Datatype.Type.LIST) {
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
            if (var.getDatatype().getType() == Datatype.Type.LIST) {
                variables.put(var.getName(), ((ListObject) var.getDatatype().getValue()).getListId());
            }
        }
        return variables;
    }
    public Boolean addFunction (String name, int params, Boolean isExport){
        FunctionDeclaration add = new FunctionDeclaration(name,params,isExport);
        return functions.add(add);
    }
    @Override
    public String toString() {
        return "ResponseManager{" +
                "steps=" + steps +
                '}';
    }
    public ArrayList<Step> getSteps(){
        return steps;
    }
}

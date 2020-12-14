package com.myerlang.erlapi.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myerlang.erlapi.response.pojos.FunctionDeclaration;
import com.myerlang.erlapi.response.pojos.Step;

import java.util.ArrayList;

class ResponseFormat {
    private ArrayList<FunctionDeclaration> principalFunctions;
    private ArrayList<Step> steps;
    private String errorMessage;

    public ResponseFormat(ArrayList<Step> steps, ArrayList<FunctionDeclaration> principalFunctions) {
        this.steps = steps;
        this.principalFunctions= principalFunctions;
        this.errorMessage = null;
    }

    public ResponseFormat(String errorMessage) {
        this.principalFunctions = null;
        this.steps = null;
        this.errorMessage = errorMessage;
    }
}

class JSONFormat {
    private Boolean error;
    private ResponseFormat response;

    public JSONFormat(Boolean error, ResponseFormat response) {
        this.error = error;
        this.response = response;
    }
}

public class StepToJson {

    private ResponseManager responseManager;
    private GsonBuilder gsonBuilder;

    public StepToJson(ResponseManager responseManager) {
        this.responseManager = responseManager;
        this.gsonBuilder = new GsonBuilder();
    }
    public StepToJson() {
        this.responseManager = new ResponseManager();
        this.gsonBuilder = new GsonBuilder();
    }
    public void nextLineFunction(){
        for(Step step: responseManager.getSteps()){
            int nextStep = responseManager.getSteps().indexOf(step)+1;
            try{
                int res = responseManager.getSteps().get(nextStep).getCurrentLine();
                step.setNextLine(res);
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("ULTIMA LINEA");
            }
        }
    }
    public String StepsToJson() {
        Gson gson = gsonBuilder.create();
        nextLineFunction();
        ResponseFormat response = new ResponseFormat(responseManager.getSteps(),responseManager.getFunctions());
        JSONFormat test = new JSONFormat(false, response);
        return gson.toJson(test);
    }

    public String ErrorToJson(String errorMessage) {
        Gson gson = gsonBuilder.create();
        ResponseFormat response = new ResponseFormat(errorMessage);
        JSONFormat res = new JSONFormat(true, response);
        return gson.toJson(res);
    }

}

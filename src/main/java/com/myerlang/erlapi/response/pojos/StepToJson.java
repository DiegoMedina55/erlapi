package com.myerlang.erlapi.response.pojos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myerlang.erlapi.response.ResponseManager;

import java.util.ArrayList;

class ResponseFormat {
    private ArrayList<Step> steps;
    private String errorMessage;

    public ResponseFormat(ArrayList<Step> steps) {
        this.steps = steps;
        this.errorMessage = null;
    }

    public ResponseFormat(String errorMessage) {
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

    public String StepsToJson() {
        Gson gson = gsonBuilder.create();
        ResponseFormat response = new ResponseFormat(responseManager.getSteps());
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

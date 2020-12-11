package com.myerlang.erlapi.response.pojos;

import java.util.ArrayList;
import java.util.HashMap;

public class Step {
    Integer currentLine;
    Integer nextLine;
    String output;
    HashMap<String, Object> objects;
    ArrayList<StepFunction> functions;

    public Step(Integer currentLine, Integer nextLine, String output, HashMap<String, Object> objects, ArrayList<StepFunction> functions) {
        this.currentLine = currentLine;
        this.nextLine = nextLine;
        this.output = output;
        this.objects = objects;
        this.functions = functions;
    }

    public Integer getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(Integer currentLine) {
        this.currentLine = currentLine;
    }

    public Integer getNextLine() {
        return nextLine;
    }

    public void setNextLine(Integer nextLine) {
        this.nextLine = nextLine;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public HashMap<String, Object> getObjects() {
        return objects;
    }

    public void setObjects(HashMap<String, Object> objects) {
        this.objects = objects;
    }

    public ArrayList<StepFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(ArrayList<StepFunction> functions) {
        this.functions = functions;
    }
}

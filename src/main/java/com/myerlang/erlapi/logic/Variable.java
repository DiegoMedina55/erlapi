package com.myerlang.erlapi.logic;

public class Variable {
    private String name;
    private boolean isParam;
    private boolean isObject;
    private Datatype value;

    public Variable(String name, boolean isParam, boolean isObject, Datatype value) {
        this.name = name;
        this.isParam = isParam;
        this.isObject = isObject;
        this.value = value;
    }

    public Variable(String name, boolean isParam, boolean isObject) {
        this.name = name;
        this.isParam = isParam;
        this.isObject = isObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isParam() {
        return isParam;
    }

    public void setParam(boolean param) {
        isParam = param;
    }

    public boolean isObject() {
        return isObject;
    }

    public void setObject(boolean object) {
        isObject = object;
    }

    public Datatype getValue() {
        return value;
    }

    public void setValue(Datatype value) {
        this.value = value;
    }
}

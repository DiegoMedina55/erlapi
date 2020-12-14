package com.myerlang.erlapi.logic;

public class Variable {
    private String name;
    private boolean isParam;
    private Datatype datatype;

    public Variable(String name, boolean isParam, Datatype value) {
        this.name = name;
        this.isParam = isParam;
        this.datatype = value;
    }

    public Variable(String name, boolean isParam) {
        this.name = name;
        this.isParam = isParam;
        this.datatype = new Datatype();
    }

    public Variable(String name) {
        this.name = name;
        this.isParam = false;
        this.datatype = new Datatype();
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

    public Datatype getDatatype() {
        return datatype;
    }

    public void setDatatype(Datatype datatype) {
        this.datatype = datatype;
    }
}

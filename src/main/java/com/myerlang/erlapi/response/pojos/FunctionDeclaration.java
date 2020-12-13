package com.myerlang.erlapi.response.pojos;

public class FunctionDeclaration {
    private String name;
    private int params;
    private Boolean isExport;

    public FunctionDeclaration(String name, int params, Boolean isExport) {
        this.name = name;
        this.params = params;
        this.isExport = isExport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParams() {
        return params;
    }

    public void setParams(int params) {
        this.params = params;
    }

    public Boolean getExport() {
        return isExport;
    }

    public void setExport(Boolean export) {
        isExport = export;
    }

    @Override
    public String toString() {
        return "FunctionDeclaration{" +
                "name='" + name + '\'' +
                ", params=" + params +
                ", isExport=" + isExport +
                '}';
    }
}

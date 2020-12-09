package com.myerlang.erlapi.logic;

import javax.xml.crypto.Data;

/**
 * Memebers:
 * @Author Gabriel Andres Avendaño Casadiego  gavendanoc@unal.edu.co
 * @Author Santiago Duque Bernal              saduquebe@unal.edu.co
 * @Author Juan Diego Medina Naranjo          jmedinan@unal.edu.co
 */

public class Datatype {
    enum Type {
        BOOLEAN,
        DOUBLE,
        ATOM,
        STRING,
        LIST,
        VARIABLE_NAME,
    }

    private Object value;
    private Type type;


    public Datatype(Object value, Type type) {
        this.value = value;
        this.type = type;
    }
    public Datatype() {}

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isVariable(){
        return type == Type.VARIABLE_NAME;
    }


    public Datatype equalop(Datatype other) { // posiblemente se tenga que dar el contexto para los errores
        if (type != other.getType()) {
            System.out.println("Error: Solo se comparan del mismo tipo de dato");
            System.exit(-1);
        }
        Datatype result = new Datatype();
        result.setType(Type.BOOLEAN);
        result.setValue(value.equals(other.getValue()));
        return result;
    }

    public Datatype add(Datatype other) { // posiblemente se tenga que dar el contexto para los errores
        if (type != Type.DOUBLE) {
            System.out.println("Error: Add only with doubles");
            System.exit(-1);
        }
        if (type != other.getType()) {
            System.out.println("Error: Add only with doubles");
            System.exit(-1);
        }
        Datatype result = new Datatype();
        result.setType(Type.DOUBLE);
        result.setValue(((Double) value) + ((Double) other.getValue()));
        return result;
    }

    @Override
    public String toString() {
        return type + ":" + value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        Datatype other = (Datatype) obj;
        return value.equals(other.getValue());
    }
}

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

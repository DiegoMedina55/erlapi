package com.myerlang.erlapi.logic;

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
        LIST
    }

    private Object value;
    private Type type;

    public Datatype(Object value, Type type) {
        this.value = value;
        this.type = type;
    }

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
        if (type == Type.BOOLEAN)
            this.value = Utils.castToBoolean(value);
        else
            this.value = Utils.castToDouble(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

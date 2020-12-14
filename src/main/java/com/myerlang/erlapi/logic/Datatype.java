package com.myerlang.erlapi.logic;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * Memebers:
 * @Author Gabriel Andres Avendaño Casadiego  gavendanoc@unal.edu.co
 * @Author Santiago Duque Bernal              saduquebe@unal.edu.co
 * @Author Juan Diego Medina Naranjo          jmedinan@unal.edu.co
 */

public class Datatype {
    public enum Type {
        BOOLEAN,
        DOUBLE,
        ATOM,
        STRING,
        LIST,
        VARIABLE_NAME,
    }

    private Object value; // 4.0
    private Type type; // DOUBLE

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

    public Datatype greaterThanop(Datatype other) { // posiblemente se tenga que dar el contexto para los errores
        if (type != other.getType()) {
            System.out.println("Error: Solo se comparan del mismo tipo de dato");
            System.exit(-1);
        }
        Datatype result = new Datatype();
        result.setType(Type.BOOLEAN);
        if (type == Type.DOUBLE) {
                result.setValue((Double) value > (Double) other.getValue());
        }else if(type == Type.LIST){
            System.out.println("Error: Comparacion de listas en desarrollo");
            System.exit(-1);
        }else{ // atoms, strings, boolean(es atom tambien)
                String v = (String) value;
                String o = (String) other.getValue();
                int res = v.compareTo(o);
                if(res == 0){
                    result.setValue(false);
                }else{
                    result.setValue(res > 0);
                }

        }
        return result;
    }
    public Datatype lessThanop(Datatype other) { // posiblemente se tenga que dar el contexto para los errores
        if (type != other.getType()) {
            System.out.println("Error: Solo se comparan del mismo tipo de dato");
            System.exit(-1);
        }
        Datatype result = new Datatype();
        result.setType(Type.BOOLEAN);
        if (type == Type.DOUBLE) {
                result.setValue((Double) value < (Double) other.getValue());
        }else if(type == Type.LIST){
            System.out.println("Error: Comparacion de listas en desarrollo");
            System.exit(-1);
        }else{ // atoms, strings, boolean(es atom tambien)
                String v = (String) value;
                String o = (String) other.getValue();
                int res = v.compareTo(o);
                if(res == 0){
                    result.setValue(false);
                }else{
                    result.setValue(res < 0);
                }
        }
        return result;
    }

    public Datatype greaterEqualOp(Datatype other){
        Datatype go = greaterThanop(other);
        Datatype ep = equalop(other);
        Datatype result = new Datatype();
        result.setType(Type.BOOLEAN);
        result.setValue((Boolean)go.value || (Boolean)ep.value);
        return result;
    }

    public Datatype lessEqualOp(Datatype other){
        Datatype lo = lessThanop(other);
        Datatype ep = equalop(other);
        Datatype result = new Datatype();
        result.setType(Type.BOOLEAN);
        result.setValue((Boolean)lo.value || (Boolean)ep.value);
        return result;
    }

    public Datatype arithmetic(Datatype other,String op) { // posiblemente se tenga que dar el contexto para los errores
        if (type != Type.DOUBLE) {
            System.out.println("Error: Arithmetic operations only with doubles");
            System.exit(-1);
        }
        if (type != other.getType()) {
            System.out.println("Error: Arithmetic operations only with doubles.");
            System.exit(-1);
        }
        Datatype result = new Datatype();
        result.setType(Type.DOUBLE);
        double v =(Double) value;
        double o =(Double) other.getValue();
        if (op == "/" && o==0.0) {
            System.out.println("Error: Division by 0 is not possible");
            System.exit(-1);
        }
        switch (op){
            case "+":
                result.setValue(v + o);
                break;
            case "-":
                result.setValue(v - o);
                break;
            case "*":
                result.setValue(v * o);
                break;
            case "/":
                result.setValue(v / o);
                break;
            case "%":
                result.setValue(v % o);
                break;
        }
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

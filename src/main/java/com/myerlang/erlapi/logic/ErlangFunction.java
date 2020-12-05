package com.myerlang.erlapi.logic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Esta clase representa una funcion de erlang
 *
 * Por ejemplo:
 * Se tienen 3 clausulas:
 *
 * sum (0, b) -> b;
 * sum (a, b) -> a + b.
 * sum (a, b, c) -> a + b + c.
 *
 * Entonces
 *
 * name = sum
 * allClauses: {
 *     1: [sum (0, b) -> b, sum (a, b) -> a + b]
 *     2: [sum (a, b, c) -> a + b + c]
 * }
 */

public class ErlangFunction {
    private String name;
    private HashMap<Integer, ArrayList<ErlangFunctionClause>> allClauses;

    public ErlangFunction(String name) {
        this.name = name;
        allClauses = new HashMap<>();
    }

    public void addClauses(int numParams, ArrayList<ErlangFunctionClause> clauses) {
        if(allClauses.get(numParams) != null) {
            // Error: Se declaro previamente clausulas de ese tamaño
        }
        allClauses.put(numParams, clauses);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, ArrayList<ErlangFunctionClause>> getAllClauses() {
        return allClauses;
    }

    public void setAllClauses(HashMap<Integer, ArrayList<ErlangFunctionClause>> allClauses) {
        this.allClauses = allClauses;
    }

    public ArrayList<ErlangFunctionClause> getClausesOfParams(int numParams){
        return allClauses.get(numParams);
    }
}

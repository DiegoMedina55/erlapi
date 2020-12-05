package com.myerlang.erlapi.logic;

/**
 * Esta clase representa una funcion de erlang
 * Se necesita porque:
 * 1. Una funccion puede tener varias definiciones iguales
 * atom_map1(one) -> 1;
 * atom_map1(three) -> 3.
 * 2. Puede tener varios parametros
 * atom_map1(three, four) -> 34.
 * 3. Se necesita hacer pattern matching,
 * tiene sentido meter esto dentro de una funcion
 */
public class ErlangFunction {
    public ErlangFunction() {

    }
}

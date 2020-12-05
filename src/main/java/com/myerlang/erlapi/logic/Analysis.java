package com.myerlang.erlapi.logic; /**
 * Memebers:
 * @Author Gabriel Andres Avendaño Casadiego  gavendanoc@unal.edu.co
 * @Author Santiago Duque Bernal              saduquebe@unal.edu.co
 * @Author Juan Diego Medina Naranjo          jmedinan@unal.edu.co
 */

import com.myerlang.erlapi.gen.ErlangLexer;
import com.myerlang.erlapi.gen.ErlangParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Analysis {
    public static String analyse(String code) {
        String result = "";
        try{
            ErlangLexer lexer;
            lexer = new ErlangLexer(CharStreams.fromString(code));

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ErlangParser parser = new ErlangParser(tokens);
            ParseTree tree = parser.forms();

            MyVisitor<Object> loader = new MyVisitor<Object>();
            loader.visit(tree); // result = (String) loader.visit(tree);
        } catch (Exception e){
            System.err.println("Error (Test): " + e);
        }
        return result;
    }
}

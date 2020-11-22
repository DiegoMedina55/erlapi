package com.myerlang.erlapi.logic; /**
 * Memebers:
 * @Author Gabriel Andres Avendaño Casadiego  gavendanoc@unal.edu.co
 * @Author Santiago Duque Bernal              saduquebe@unal.edu.co
 * @Author Juan Diego Medina Naranjo          jmedinan@unal.edu.co
 */

import com.myerlang.erlapi.gen.BccLanguageLexer;
import com.myerlang.erlapi.gen.BccLanguageParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Analysis {
    public static String analyse(String code) {
        String result = "";
        try{
            BccLanguageLexer lexer;
            lexer = new BccLanguageLexer(CharStreams.fromString(code));

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BccLanguageParser parser = new BccLanguageParser(tokens);
            ParseTree tree = parser.prog();

            MyVisitor<Object> loader = new MyVisitor<Object>();
            result = (String) loader.visit(tree);
            System.out.println(result);
        } catch (Exception e){
            System.err.println("Error (Test): " + e);
        }
        return result;
    }
}

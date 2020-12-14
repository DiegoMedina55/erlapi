package com.myerlang.erlapi.logic; /**
 * Memebers:
 * @Author Gabriel Andres Avendaño Casadiego  gavendanoc@unal.edu.co
 * @Author Santiago Duque Bernal              saduquebe@unal.edu.co
 * @Author Juan Diego Medina Naranjo          jmedinan@unal.edu.co
 */

import com.myerlang.erlapi.gen.ErlangLexer;
import com.myerlang.erlapi.gen.ErlangParser;
import com.myerlang.erlapi.response.ResponseManager;
import com.myerlang.erlapi.response.pojos.StepToJson;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Analysis {
    public static String analyse(String code) {
        ResponseManager res = new ResponseManager();
        StepToJson error = new StepToJson();
        String result = "";
        try{
            ErlangLexer lexer;
            lexer = new ErlangLexer(CharStreams.fromString(code));
            lexer.removeErrorListeners();
            lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ErlangParser parser = new ErlangParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);
            ParseTree tree = parser.forms();

            MyVisitor<Object> loader = new MyVisitor<Object>();
            try{
                loader.visit(tree); // result = (String) loader.visit(tree);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        } catch (Exception e){
            String val;
            String row;
            String column;
            String caterror = e.getMessage();
            String[] values = caterror.split(" ");
            row = values[1].split(":")[0];
            column = values[1].split(":")[1];
            if(caterror.contains("token")){
                result = error.ErrorToJson("Linea:"+row+" Columna: "+column+" Error léxico");
            }
            else {
                result = error.ErrorToJson("Linea:"+row+" Columna: "+column+" Error sintáctico");
            }
        }
        return result;
    }
}

package com.myerlang.erlapi;

/**
 * Memebers:
 * @Author Gabriel Andres Avendaño Casadiego  gavendanoc@unal.edu.co
 * @Author Santiago Duque Bernal              saduquebe@unal.edu.co
 * @Author Juan Diego Medina Naranjo          jmedinan@unal.edu.co
 */

import com.myerlang.erlapi.logic.Analysis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class ErlapiApplication {

	public static void main(String[] args) {
		String code = "";
		try {
			code = readFile(".\\src\\main\\java\\com\\myerlang\\erlapi\\input\\input.txt", StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Analysis.analyse(code);

		//SpringApplication.run(ErlapiApplication.class, args); // No se ejecuta el framework
	}

	static String readFile(String path, Charset encoding) throws IOException {
		System.out.println(Paths.get(path).toAbsolutePath());
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

}

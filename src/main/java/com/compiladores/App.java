package com.compiladores;

import com.compiladores.lexer.Lexer;
import com.compiladores.lexer.Token;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String entrada = "3 + 5 * (10 - 2)";
        System.out.println("Entrada: " + entrada);
        System.out.println("--- Tokens ---");

        Lexer lexer = new Lexer(entrada);
        List<Token> tokens = lexer.tokenizar();

        for (Token t : tokens) {
            System.out.println(t);
        }
    }
}
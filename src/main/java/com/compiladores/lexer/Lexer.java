package com.compiladores.lexer;

import java.util.ArrayList;
import java.util.List;
public class Lexer {
    private final String texto;
    private int i = 0;
    public Lexer(String texto) {
        this.texto = texto;
    }
    public List<Token> tokenizar() {
        List<Token> tokens = new ArrayList<>();

        while (i < texto.length()) {
            char c = texto.charAt(i);
            // 1. Saltar espacios en blanco
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }
            // 2. Procesar Números
            if (Character.isDigit(c)) {
                int inicio = i;
                while (i < texto.length() && (Character.isDigit(texto.charAt(i)) || texto.charAt(i) == '.')) {
                    i++;
                }
                tokens.add(new Token(TokenType.NUMERO, texto.substring(inicio, i)));
                continue; // Saltamos al siguiente ciclo sin avanzar i otra vez
            }
            // 3. Procesar Operadores y Símbolos
            switch (c) {
                case '+' -> tokens.add(new Token(TokenType.SUMA, "+"));
                case '-' -> tokens.add(new Token(TokenType.RESTA, "-"));
                case '*' -> tokens.add(new Token(TokenType.MULTIPLICACION, "*"));
                case '/' -> tokens.add(new Token(TokenType.DIVISION, "/"));
                case '(' -> tokens.add(new Token(TokenType.PAREN_IZQ, "("));
                case ')' -> tokens.add(new Token(TokenType.PAREN_DER, ")"));
                default -> throw new RuntimeException("Carácter no válido: " + c);
            }
            i++; 
        }
        tokens.add(new Token(TokenType.EOF, ""));
        return tokens;
    }
}

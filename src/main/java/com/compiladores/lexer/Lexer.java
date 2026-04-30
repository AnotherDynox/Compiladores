package com.compiladores.lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final String texto;
    private int posicion;

    public Lexer(String texto) {
        this.texto = texto;
        this.posicion = 0;
    }

    private char caracterActual() {
        return texto.charAt(posicion);
    }

    private void avanzar() {
        posicion++;
    }

    private void saltarEspacios() {
        while (posicion < texto.length() && 
               Character.isWhitespace(caracterActual())) {
            avanzar();
        }
    }

    private Token leerNumero() {
        StringBuilder sb = new StringBuilder();
        while (posicion < texto.length() && 
               (Character.isDigit(caracterActual()) || 
                caracterActual() == '.')) {
            sb.append(caracterActual());
            avanzar();
        }
        return new Token(TokenType.NUMERO, sb.toString());
    }

    public List<Token> tokenizar() {
        List<Token> tokens = new ArrayList<>();

        while (posicion < texto.length()) {
            saltarEspacios();
            if (posicion >= texto.length()) break;

            char c = caracterActual();

            if (Character.isDigit(c)) {
                tokens.add(leerNumero());
            } else {
                switch (c) {
                    case '+' -> { tokens.add(new Token(TokenType.SUMA, "+")); avanzar(); }
                    case '-' -> { tokens.add(new Token(TokenType.RESTA, "-")); avanzar(); }
                    case '*' -> { tokens.add(new Token(TokenType.MULTIPLICACION, "*")); avanzar(); }
                    case '/' -> { tokens.add(new Token(TokenType.DIVISION, "/")); avanzar(); }
                    case '(' -> { tokens.add(new Token(TokenType.PAREN_IZQ, "(")); avanzar(); }
                    case ')' -> { tokens.add(new Token(TokenType.PAREN_DER, ")")); avanzar(); }
                    default  -> throw new RuntimeException(
                        "Carácter desconocido: '" + c + "' en posición " + posicion
                    );
                }
            }
        }

        tokens.add(new Token(TokenType.EOF, ""));
        return tokens;
    }
}
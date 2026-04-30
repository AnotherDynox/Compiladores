package com.compiladores.lexer;

public class Token {
    public final TokenType t;
    public final String v;

    public Token(TokenType t, String v) {
        this.tipo = t;
        this.valor = v;
    }

    @Override
    public String toString() {
        return "Token(" + t + ", '" + v + "')";
    }
}

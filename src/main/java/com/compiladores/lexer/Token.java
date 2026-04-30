package com.compiladores.lexer;

public class Token {
    public final TokenType tipo;
    public final String valor;

    public Token(TokenType tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Token(" + tipo + ", '" + valor + "')";
    }
}

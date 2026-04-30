package com.compiladores.parser;

import com.compiladores.lexer.Token;
import com.compiladores.lexer.TokenType;
import java.util.List;
public class Parser {
    private final List<Token> tokens;
    private int i = 0; // Índice corto para legibilidad
    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }
    // Método auxiliar: ¿Es el token que espero? Si sí, lo consumo.
    private boolean match(TokenType tipo) {
        if (tokens.get(i).tipo == tipo) {
            i++;
            return true;
        }
        return false;
    }
    public void parsear() {
        expresion();
        if (tokens.get(i).tipo != TokenType.EOF) {
            throw new RuntimeException("Error: Caracteres extraños al final.");
        }
    }
    // Regla: Suma y Resta
    private void expresion() {
        termino();
        while (match(TokenType.SUMA) || match(TokenType.RESTA)) {
            termino();
        }
    }
    // Regla: Multiplicación y División
    private void termino() {
        factor();
        while (match(TokenType.MULTIPLICACION) || match(TokenType.DIVISION)) {
            factor();
        }
    }
    // Regla: Números y Paréntesis
    private void factor() {
        if (match(TokenType.NUMERO)) {
            // No hace nada, solo "pasa" el token
        } else if (match(TokenType.PAREN_IZQ)) {
            expresion();
            if (!match(TokenType.PAREN_DER)) {
                throw new RuntimeException("Falta cerrar paréntesis ')'.");
            }
        } else {
            throw new RuntimeException("Error: Se esperaba número o '('");
        }
    }
}

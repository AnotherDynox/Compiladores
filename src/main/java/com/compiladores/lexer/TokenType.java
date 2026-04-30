package com.compiladores.lexer;

public enum TokenType {
    // Literales
    NUMERO,         // 123, 45.6

    // Operadores aritméticos
    SUMA,           // +
    RESTA,          // -
    MULTIPLICACION, // *
    DIVISION,       // /

    // Agrupación
    PAREN_IZQ,      // (
    PAREN_DER,      // )

    // Control
    EOF             // fin de la entrada
}

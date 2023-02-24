package com.example.RuuderStack.Server.exception;

import lombok.AllArgsConstructor;

/**
 * Exception to be thrown in case of a source type not found
 */
@AllArgsConstructor
public class SourceNotFoundException extends RuntimeException {

    private String message;
}

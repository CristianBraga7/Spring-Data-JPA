package com.example.libraryapi.execeptions;

public class RegistroDuplicadoException extends RuntimeException {

    public RegistroDuplicadoException(String message) {
        super(message);
    }
}

package com.example.libraryapi.execeptions;


public class OperacaoNaoPermitidaException extends RuntimeException {
    public OperacaoNaoPermitidaException(String message) {
        super(message);
    }
}

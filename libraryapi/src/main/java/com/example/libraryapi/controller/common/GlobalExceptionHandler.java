package com.example.libraryapi.controller.common;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.libraryapi.controller.dto.ErroResposta;
import java.util.List;
import org.springframework.validation.FieldError;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import com.example.libraryapi.controller.dto.ErroCampo;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResposta handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        List<ErroCampo> listaErrors = fieldErrors.stream().map(fe -> new ErroCampo(fe.getField(), fe.getDefaultMessage()))
        .collect(Collectors.toList());
        return new ErroResposta(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validacao", listaErrors);
    }
}
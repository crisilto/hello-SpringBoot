package com.crisilto.userapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice //Marcamos la clase como una clase de asesoramiento controlador.
//Puede manejar excepciones de forma global para todos los controladores.
public class GlobaLExceptionHandler {

    //Manejo de excepciones de validación.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    //Manejo de excepciones generales.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalExceptions(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //@ExceptionHandler: Anotación que indica que el método manejará excepciones de un tipo específico.
    //MethodArgumentNotValidException: Maneja errores de validación, como cuando los datos de entrada no cumplen con las restricciones definidas.
    //Exception:  Captura cualquier excepción general que no esté manejada por otros métodos.

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(IdNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

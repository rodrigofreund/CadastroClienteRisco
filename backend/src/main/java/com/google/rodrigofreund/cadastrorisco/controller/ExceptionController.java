package com.google.rodrigofreund.cadastrorisco.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.google.rodrigofreund.cadastrorisco.exception.BusinessException;
import com.google.rodrigofreund.cadastrorisco.exception.ErrorResponse;

@ControllerAdvice
public class ExceptionController {

    static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> businessExceptionHandler(BusinessException ex) {
        ErrorResponse error = ErrorResponse.builder().build();
        log.error("ERRO NA APLICAÇÃO", ex);
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

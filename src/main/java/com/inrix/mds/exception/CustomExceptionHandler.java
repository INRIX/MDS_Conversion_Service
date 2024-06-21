package com.inrix.mds.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ParamErrors.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleParamErrors(ParamErrors msg) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg.getMessage());
    }
}


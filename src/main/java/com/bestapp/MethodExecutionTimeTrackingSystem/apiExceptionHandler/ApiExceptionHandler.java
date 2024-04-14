package com.bestapp.MethodExecutionTimeTrackingSystem.apiExceptionHandler;

import com.bestapp.MethodExecutionTimeTrackingSystem.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String entityNotFoundExceptionHandler(NotFoundException e) {
        return e.getMessage();
    }
}

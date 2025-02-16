package com.catalog.infrastructure.configuration;

import com.catalog.domain.exception.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class PriceControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { PriceNotFoundException.class })
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(WebRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

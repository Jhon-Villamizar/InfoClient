package com.pearls.InfoClient.exception;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Manejo de acuerdo a los tipos de excepciones lanzados desde los controladores
     * 
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = { Exception.class, NoSuchElementException.class, EntityNotFoundException.class })
    protected ResponseEntity<Object> handleConflict(EntityNotFoundException ex, WebRequest request) {
          ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
          apiError.setMessage(ex.getMessage());
          apiError.setDebugMessage(ex.getMessage());
          return buildResponseEntity(apiError);
    }

    /**
     * Build Response
     * @param apiError
     * @return
     */
    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
          return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}

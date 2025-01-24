package com.perfuma2.interfaces.rest;

import com.perfuma2.domain.exception.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Generic exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestResponse> handleGenericException(Exception ex) {
        RestResponse response = new RestResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred: " + ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Domain errors handler
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<RestResponse> handleDomainError(DomainException ex) {
        // Usamos el código de estado y el mensaje de la excepción
        RestResponse response = new RestResponse(
                ex.getStatus(),  // Código de estado dinámico de la excepción
                ex.getMessage()     // Mensaje de la excepción
        );

        // Devolvemos la respuesta con el código de estado adecuado
        return new ResponseEntity<>(response, response.getStatusCode());
    }

}

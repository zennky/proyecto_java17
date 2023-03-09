package com.academia.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

// Para capturar los errores del tipo HTTP se hereda de la clase abstract ResponseEntityExceptionHandler
// podremos capturar errores del tipo HTTP

/**
 * Clase que implementa la captura de las excepcion a momento de realizar el response
 */
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    /*
     * Para capturar todos los tipos de exceptions
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handlerModelFoundException(Exception ex, WebRequest req){
        CustomErrorResponse er = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));

        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
        Este codigo esta soportado antes de Spring Boot 3.0
    * */
    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handlerModelFoundException(ModelNotFoundException ex, WebRequest req){
        CustomErrorResponse er = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));

        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<CustomErrorResponse> handlerModelFoundException(SQLException ex, WebRequest req){
        CustomErrorResponse er = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));

        return new ResponseEntity<>(er, HttpStatus.CONFLICT);
    }

    /**
     * Para poder capturar las excepciones del tipo http
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest req) {

        CustomErrorResponse er = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));

        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    /**
     * Metodo que permite capturar las excepcion que seran lanzadas por los validators de jakarta
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest req) {

        // personalizando el mensaje a devolver
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                // joining, realiza la concatenacion
                .collect(Collectors.joining(" "));

        CustomErrorResponse er = new CustomErrorResponse(LocalDateTime.now(), message, req.getDescription(false));

        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

}

package com.academia.exception;

/**
 * Clase que maneja las excepciones cuando no encuentra un entity
 */
public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(String message){
        super(message);
    }

}

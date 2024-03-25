package com.develcode.develfood.services.exception.validation;

public class EmailExistsException extends RuntimeException{
    public EmailExistsException(String message) {super(message);}
}

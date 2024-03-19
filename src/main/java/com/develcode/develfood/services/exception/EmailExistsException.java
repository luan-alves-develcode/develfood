package com.develcode.develfood.services.exception;

public class EmailExistsException extends RuntimeException{
    public EmailExistsException(String message) {super(message);}
}

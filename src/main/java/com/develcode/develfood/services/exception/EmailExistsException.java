package com.develcode.develfood.services.exception;

import com.develcode.develfood.exception.ValidationException;

public class EmailExistsException extends ValidationException {
    public EmailExistsException(String message) {super(message);}
}

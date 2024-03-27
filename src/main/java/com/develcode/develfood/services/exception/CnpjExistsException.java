package com.develcode.develfood.services.exception;

import com.develcode.develfood.exception.ValidationException;

public class CnpjExistsException extends ValidationException {
    public CnpjExistsException(String message) {super(message);}
}

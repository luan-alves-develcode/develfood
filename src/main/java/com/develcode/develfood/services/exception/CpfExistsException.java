package com.develcode.develfood.services.exception;

import com.develcode.develfood.exception.ValidationException;

public class CpfExistsException extends ValidationException {
    public CpfExistsException(String message) {super(message);}
}

package com.fabric.waterManagement.exceptions;

public class InvalidFileNameException extends RuntimeException {

    private String message;
    public InvalidFileNameException(String message) {

        super(message);
        this.message = message;
    }
}

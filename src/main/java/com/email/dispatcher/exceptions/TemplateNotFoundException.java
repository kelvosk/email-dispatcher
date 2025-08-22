package com.email.dispatcher.exceptions;

public class EmailNotFoundException extends RuntimeException{
    EmailNotFoundException(String message) {
        super(message);
    }
}

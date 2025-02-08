package com.email.dispatcher.exceptions;

public class EmailException extends RuntimeException{
    EmailException (String message) {
        super(message);
    }
}

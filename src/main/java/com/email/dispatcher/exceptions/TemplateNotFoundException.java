package com.email.dispatcher.exceptions;

public class TemplateNotFoundException extends RuntimeException{
    TemplateNotFoundException(String message) {
        super(message);
    }
}

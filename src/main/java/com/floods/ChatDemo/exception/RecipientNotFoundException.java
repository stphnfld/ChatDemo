package com.floods.ChatDemo.exception;

public class RecipientNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public RecipientNotFoundException(String message) {
        super(message);
    }
}
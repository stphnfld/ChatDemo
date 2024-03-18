package com.floods.ChatDemo.exception;

public class InvalidMessageException extends RuntimeException {
    private static final long serialVersionUID = 1L;
	
    public InvalidMessageException(String message) {
        super(message);
    }
}
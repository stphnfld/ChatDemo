package com.floods.ChatDemo.model;

public class Confirmation {
    private boolean success;
    private String error;

    public Confirmation(boolean success) {
        this.success = success;
    }

    public Confirmation(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

    
}
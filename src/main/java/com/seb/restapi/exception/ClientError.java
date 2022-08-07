package com.seb.restapi.exception;

import java.util.List;

public class ClientError {

    private String message;
    private List<String> details;
    
    public ClientError(String message, List<String> details) {
    	super();
        this.message = message;
        this.details = details;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
}

package com.example.ecommerce.CatalogueDemo.entity;

import java.util.List;

public class ErrorResponse {
	
	private String errorCode;
    private List<String> errorMessages;
    
	public ErrorResponse(String errorCode, List<String> errorMessages) {
		this.errorCode = errorCode;
		this.errorMessages = errorMessages;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

}

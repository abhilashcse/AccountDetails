package com.accountDetails.response;

public class ErrorResponse {

	private String errorType;
	private String errorMessage;
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ErrorResponse(String errorType, String errorMessage) {
		super();
		this.errorType = errorType;
		this.errorMessage = errorMessage;
	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

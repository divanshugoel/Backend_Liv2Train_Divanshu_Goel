package org.liv2train.app.student.training.centre.locator.response.dto;

public enum ErrorMessages {

	EMAIL_ALREADY_EXISTS(101, "Email already exists");

	private Integer errorCode;
	private String errorMessages;

	private ErrorMessages(Integer errorCode, String errorMessages) {
		this.errorMessages = errorMessages;
		this.errorCode = errorCode;
	}

	public String getErrorMessages() {
		return errorMessages;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

}

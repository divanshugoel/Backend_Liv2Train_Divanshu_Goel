package org.liv2train.app.student.training.centre.locator.response.dto;

/**
 * It sends custom error codes and error messages when exception occurs.
 * 
 * 
 * @author Divanshu_Goel
 * 
 */

public enum ErrorMessages {

	/**
	 * 
	 * EMAIL_ALREADY_EXISTS sends error code 101 and error message email already
	 * exist if trainingCentre already exists with this email.
	 * 
	 */
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

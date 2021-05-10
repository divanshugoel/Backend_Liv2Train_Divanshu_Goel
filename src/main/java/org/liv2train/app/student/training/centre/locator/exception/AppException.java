package org.liv2train.app.student.training.centre.locator.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * AppException is a custom exception class for the custom 
 * exceptions thrown during method calls.
 * 
 * @See TrainingCentreServiceImpl 
 * 
 * @author Divanshu_Goel
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Integer errorCode;
	private String message;
	

}

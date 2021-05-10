package org.liv2train.app.student.training.centre.locator.exception;

import java.util.Date;

import org.liv2train.app.student.training.centre.locator.response.dto.ErrorResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * A convenient class for {@link ControllerAdvice @ControllerAdvice} classes
 * that wish to provide centralized custom exception handling across all
 * {@code @RequestMapping} methods.
 * 
 * @author Divanshu_Goel
 *
 */

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * handleAppException is a method to customize the response for AppException.
	 * 
	 * @param ex      the exception {@link -> AppException}
	 * @param request the current request {@link -> WebRequest}
	 * @return a {@code ResponseEntity} instance
	 * @since 1.0
	 * @version 1.0
	 */

	@ExceptionHandler(value = { AppException.class })
	protected ResponseEntity<Object> handleAppException(AppException ex, WebRequest request) {
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(new Date(), ex.getErrorCode(), ex.getMessage());
		return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * handleMethodArgumentNotValid is a method to customize the response for
	 * MethodArgumentNotValidException.
	 * 
	 * @param ex      the exception {@link -> MethodArgumentNotValidException}
	 * @param headers the headers to be written to the response {@link ->
	 *                HttpHeaders}
	 * @param status  the selected response status {@link -> HttpHeaders}
	 * @param request the current request {@link -> WebRequest}
	 * @return a {@code ResponseEntity} instance
	 * @since 1.0
	 * @version 1.0
	 */

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(new Date(), HttpStatus.BAD_REQUEST.value(),
				"Validation Failed. " + ex.getLocalizedMessage());
		return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
	}
}

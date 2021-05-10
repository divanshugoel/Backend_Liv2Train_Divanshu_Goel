package org.liv2train.app.student.training.centre.locator.response.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDTO {
	private Date timestamp;
	private Integer erroCode;

	private String errorMessage;

}

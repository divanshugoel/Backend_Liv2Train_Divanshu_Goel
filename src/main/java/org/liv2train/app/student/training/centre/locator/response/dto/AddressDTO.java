package org.liv2train.app.student.training.centre.locator.response.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {

	@NotNull(message = "centre address cannot be null ")
	@NotEmpty(message = "centre address cannot be empty ")
	String detailedAddress;

	@NotNull(message = "centre city cannot be null ")
	@NotEmpty(message = "centre city cannot be empty ")
	String city;

	@NotNull(message = "centre state cannot be null ")
	@NotEmpty(message = "centre state cannot be empty ")
	String state;

	@NotNull(message = "centre pincode cannot be null ")
	@NotEmpty(message = "centre pincode cannot be empty ")
	String pincode;
}

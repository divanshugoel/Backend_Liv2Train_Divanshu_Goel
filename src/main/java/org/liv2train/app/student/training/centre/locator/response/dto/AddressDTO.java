package org.liv2train.app.student.training.centre.locator.response.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * AddressDTO is the POJO class for sending the address object to the
 * trainingCentreResponseDTO.
 * 
 * @author Divanshu_Goel
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {

	@NotNull(message = "centre address cannot be null ")
	@NotEmpty(message = "centre address cannot be empty ")
	private String detailedAddress;

	@NotNull(message = "centre city cannot be null ")
	@NotEmpty(message = "centre city cannot be empty ")
	private String city;

	@NotNull(message = "centre state cannot be null ")
	@NotEmpty(message = "centre state cannot be empty ")
	private String state;

	@NotNull(message = "centre pincode cannot be null ")
	@NotEmpty(message = "centre pincode cannot be empty ")
	private String pincode;

	/**
	 * 
	 * This method return string representation of the AddressDTO object.
	 * 
	 * @return String {@link -> String}.
	 * @since 1.0
	 * @version 1.0
	 * 
	 */
	@Override
	public String toString() {
		return "AddressDTO [detailedAddress=" + detailedAddress + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + "]";
	}

}

package org.liv2train.app.student.training.centre.locator.request.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.liv2train.app.student.training.centre.locator.response.dto.AddressDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * TrainingCentreRequestDTO is the POJO class for sending the request.
 * 
 * It sends trainingCentreRequestDTO object. 
 * 
 * @author Divanshu_Goel
 * 
 */

@Getter
@Setter
@NoArgsConstructor
public class TrainingCentreRequestDTO {

	@NotNull(message = "centre name cannot be null ")
	@NotEmpty(message = "centre name cannot be empty ")
	@Size(max = 40, message = "Centre name is too long")
	private String centreName;

	@NotNull(message = "centre code cannot be null ")
	@NotEmpty(message = "centre code cannot be empty ")
	@Pattern(regexp = "^[\\p{Alnum}]{1,12}$", message = "invalid centre code")
	private String centreCode;

	Integer studentCapacity;
	private List<String> coursesOfferd;

	@NotNull(message = "centre address cannot be null ")
	private AddressDTO address;

	@Email(message = "Please enter a valid email id")
	private String email;

	@NotNull(message = "centre contact details cannot be null ")
	@NotEmpty(message = "centre contact details be empty ")
	@Pattern(regexp = "^[7-9][0-9]{9}$", message = "Please enter a valid phone number")
	private String phoneNumber;

	
	/**
	 * 
	 * This method return string representation of the 
	 * trainingCentreRequestDTO object.
	 * 
	 * @return String {@link -> String}.
	 * @since 1.0
	 * @version 1.0
	 
	 */
	@Override
	public String toString() {
		return "TrainingCentreRequestDTO [centreName=" + centreName + ", centreCode=" + centreCode
				+ ", studentCapacity=" + studentCapacity + ", coursesOfferd=" + coursesOfferd + ", address=" + address
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	

}

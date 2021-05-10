package org.liv2train.app.student.training.centre.locator.response.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TrainingCentreResponseDTO is the POJO class for sending the response back
 * on success.
 * It sends trainingCentre responseDTO object. 
 * 
 * @author Divanshu_Goel
 * 
 */

@Getter
@Setter
@NoArgsConstructor
public class TrainingCentreResponseDTO {
	private String centreName;
	private String centreCode;
	private Integer studentCapacity;
	private List<String> coursesOfferd;
	private AddressDTO address;
	private String email;
	private String phoneNumber;
	private String createdOn;

}

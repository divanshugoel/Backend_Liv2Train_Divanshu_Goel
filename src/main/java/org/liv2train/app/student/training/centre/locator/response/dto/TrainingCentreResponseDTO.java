package org.liv2train.app.student.training.centre.locator.response.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrainingCentreResponseDTO {
	String centreName;
	String centreCode;
	Integer studentCapacity;
	List<String> coursesOfferd;
	AddressDTO address;
	String email;
	String phoneNumber;

}

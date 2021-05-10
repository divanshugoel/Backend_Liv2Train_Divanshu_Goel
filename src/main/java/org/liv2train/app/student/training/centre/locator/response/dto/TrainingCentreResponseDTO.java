package org.liv2train.app.student.training.centre.locator.response.dto;

import java.time.Instant;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

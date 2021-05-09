package org.liv2train.app.student.training.centre.locator.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.liv2train.app.student.training.centre.locator.model.Address;
import org.liv2train.app.student.training.centre.locator.model.TrainingCentre;
import org.liv2train.app.student.training.centre.locator.request.dto.TrainingCentreRequestDTO;
import org.liv2train.app.student.training.centre.locator.response.dto.AddressDTO;
import org.liv2train.app.student.training.centre.locator.response.dto.TrainingCentreResponseDTO;
import org.liv2train.app.student.training.centre.locator.service.impl.TrainingCentreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trainingcentre")
public class TrainingCentreController {
	@Autowired
	TrainingCentreServiceImpl trainingCentreService;


	@PostMapping("/save")
	public ResponseEntity<TrainingCentreResponseDTO> createTrainingCentre(
			@Valid @RequestBody TrainingCentreRequestDTO trainingCentreRequestDTO) {

		TrainingCentre createdTrainingCentre = trainingCentreService.createTrainingCentre(trainingCentreRequestDTO);
		TrainingCentreResponseDTO trainingCentreResponseDTO = prepareResponse(createdTrainingCentre);
		return ResponseEntity.status(HttpStatus.OK).body(trainingCentreResponseDTO);

	}

	@GetMapping("/all")
	public ResponseEntity<List<TrainingCentreResponseDTO>> getAllTrainingCentres() {
		List<TrainingCentreResponseDTO> trainingCentreResponseDTOList = new ArrayList<>();
		List<TrainingCentre> allTrainingCentres = trainingCentreService.getAllTrainingCentre();
		for (TrainingCentre trainingCentre : allTrainingCentres) {
			TrainingCentreResponseDTO trainingCentreResponseDTO = prepareResponse(trainingCentre);
			trainingCentreResponseDTOList.add(trainingCentreResponseDTO);
		}
		return ResponseEntity.status(HttpStatus.OK).body(trainingCentreResponseDTOList);
	}

	private TrainingCentreResponseDTO prepareResponse(TrainingCentre createdTrainingCentre) {
		TrainingCentreResponseDTO trainingCentreResponseDTO = new TrainingCentreResponseDTO();
		AddressDTO addressDTO = new AddressDTO();
		trainingCentreResponseDTO.setCentreName(createdTrainingCentre.getCentreName());
		trainingCentreResponseDTO.setCentreCode(createdTrainingCentre.getCentreCode());
		trainingCentreResponseDTO.setStudentCapacity(createdTrainingCentre.getStudentCapacity());
		trainingCentreResponseDTO.setPhoneNumber(createdTrainingCentre.getPhoneNumber());
		trainingCentreResponseDTO.setEmail(createdTrainingCentre.getEmail());
		Address address = createdTrainingCentre.getAddress();
		addressDTO.setState(address.getState());
		addressDTO.setPincode(address.getPincode());
		addressDTO.setDetailedAddress(address.getDetailedAddress());
		addressDTO.setCity(address.getCity());
		trainingCentreResponseDTO.setAddress(addressDTO);
		String course = createdTrainingCentre.getCourses();
		List<String> courses = Arrays.asList(course.split(","));
		trainingCentreResponseDTO.setCoursesOfferd(courses);
		return trainingCentreResponseDTO;
	}

}

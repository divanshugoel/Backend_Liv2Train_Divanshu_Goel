package org.liv2train.app.student.training.centre.locator.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.liv2train.app.student.training.centre.locator.exception.AppException;
import org.liv2train.app.student.training.centre.locator.model.Address;
import org.liv2train.app.student.training.centre.locator.model.TrainingCentre;
import org.liv2train.app.student.training.centre.locator.request.dto.TrainingCentreRequestDTO;
import org.liv2train.app.student.training.centre.locator.response.dto.AddressDTO;
import org.liv2train.app.student.training.centre.locator.response.dto.TrainingCentreResponseDTO;
import org.liv2train.app.student.training.centre.locator.service.impl.TrainingCentreServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * TrainingCentreController is a controller class. It creates a trainingCentre.
 * It gets a list of all trainingCentre.
 * 
 * @author Divanshu_Goel
 *
 */
@RestController
@RequestMapping("/api/trainingcentre")
public class TrainingCentreController {

	@Autowired
	TrainingCentreServiceImpl trainingCentreService;

	private static final Logger LOGGER = LoggerFactory.getLogger(TrainingCentreController.class);

	/**
	 * creates new trainingCentre when trainingCentreRequestDTO is passed as a input
	 * parameter
	 *
	 * @param trainingCentreRequestDTO {@link -> TrainingCentreRequestDTO}.
	 * @return a {@code ResponseEntity} instance.
	 * @throws AppException in case the TrainingCentreRequestDTO contains email that
	 *                      already exists.
	 * @since 1.0
	 * @version 1.0
	 */

	@PostMapping("/save")
	public ResponseEntity<TrainingCentreResponseDTO> createTrainingCentre(
			@Valid @RequestBody TrainingCentreRequestDTO trainingCentreRequestDTO) throws Exception {
		LOGGER.info("Inside createTrainingCentre");

		TrainingCentre createdTrainingCentre = trainingCentreService.createTrainingCentre(trainingCentreRequestDTO);
		TrainingCentreResponseDTO trainingCentreResponseDTO = prepareResponse(createdTrainingCentre);

		final URI location = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/api/trainingcentre/{id}")
				.build().expand(createdTrainingCentre.getId()).toUri();
		final HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		LOGGER.info("Exiting createTrainingCentre");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(trainingCentreResponseDTO);

	}

	/**
	 * Returns all instances of the TrainingCentre in a list.
	 * 
	 * @return a {@code ResponseEntity} instance.
	 * @since 1.0
	 * @version 1.0
	 */

	@GetMapping("/all")
	public ResponseEntity<List<TrainingCentreResponseDTO>> getAllTrainingCentres() {
		LOGGER.info("Inside getAllTrainingCentres");
		List<TrainingCentreResponseDTO> trainingCentreResponseDTOList = new ArrayList<>();
		List<TrainingCentre> allTrainingCentres = trainingCentreService.getAllTrainingCentre();
		for (TrainingCentre trainingCentre : allTrainingCentres) {
			TrainingCentreResponseDTO trainingCentreResponseDTO = prepareResponse(trainingCentre);
			trainingCentreResponseDTOList.add(trainingCentreResponseDTO);
		}
		LOGGER.info("Exiting getAllTrainingCentres");
		return ResponseEntity.status(HttpStatus.OK).body(trainingCentreResponseDTOList);

	}

	/**
	 * prepareResponse is a method that maps fields of trainingCentre object to
	 * trainingCentreResponseDTO object
	 * 
	 * @param createdTrainingCentre {@link -> TrainingCentre}.
	 * @return trainingCentreResponseDTO {@link -> TrainingCentreResponseDTO}.
	 * @since 1.0
	 * @version 1.0
	 */

	private TrainingCentreResponseDTO prepareResponse(TrainingCentre createdTrainingCentre) {
		TrainingCentreResponseDTO trainingCentreResponseDTO = new TrainingCentreResponseDTO();
		AddressDTO addressDTO = new AddressDTO();
		trainingCentreResponseDTO.setCentreName(createdTrainingCentre.getCentreName());
		trainingCentreResponseDTO.setCentreCode(createdTrainingCentre.getCentreCode());
		trainingCentreResponseDTO.setStudentCapacity(createdTrainingCentre.getStudentCapacity());
		trainingCentreResponseDTO.setPhoneNumber(createdTrainingCentre.getPhoneNumber());
		trainingCentreResponseDTO.setEmail(createdTrainingCentre.getEmail());
		trainingCentreResponseDTO.setCreatedOn(createdTrainingCentre.getCreatedOn().toString());
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

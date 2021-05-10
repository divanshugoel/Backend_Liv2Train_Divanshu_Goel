package org.liv2train.app.student.training.centre.locator.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.liv2train.app.student.training.centre.locator.exception.AppException;
import org.liv2train.app.student.training.centre.locator.mapper.AddressMapper;
import org.liv2train.app.student.training.centre.locator.mapper.TrainingCentreMapper;
import org.liv2train.app.student.training.centre.locator.model.Address;
import org.liv2train.app.student.training.centre.locator.model.TrainingCentre;
import org.liv2train.app.student.training.centre.locator.repository.AddressRepository;
import org.liv2train.app.student.training.centre.locator.repository.TrainingCentreRepository;
import org.liv2train.app.student.training.centre.locator.request.dto.TrainingCentreRequestDTO;
import org.liv2train.app.student.training.centre.locator.response.dto.ErrorMessages;
import org.liv2train.app.student.training.centre.locator.service.TrainingCentreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingCentreServiceImpl implements TrainingCentreService {
	@Autowired
	TrainingCentreRepository trainingCentreRepository;

	@Autowired
	AddressRepository addressRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(TrainingCentreServiceImpl.class);

	@Override
	public TrainingCentre createTrainingCentre(TrainingCentreRequestDTO trainingCentreRequestDTO) throws Exception {

		Address address = AddressMapper.mapToVO(trainingCentreRequestDTO.getAddress());
		TrainingCentre trainingCentre = TrainingCentreMapper.mapToVO(trainingCentreRequestDTO);
		trainingCentre.setAddress(address);
		if (existByEmailId(trainingCentre)) {
			LOGGER.error("cannot create a training centre, email already exists");
			throw new AppException(ErrorMessages.EMAIL_ALREADY_EXISTS.getErrorCode(),
					ErrorMessages.EMAIL_ALREADY_EXISTS.getErrorMessages());
		}

		TrainingCentre savedtrainingCentre = trainingCentreRepository.save(trainingCentre);
		LOGGER.info("Training centre created with id ={}", savedtrainingCentre.getId());
		return savedtrainingCentre;
	}

	@Override
	public List<TrainingCentre> getAllTrainingCentre() {
		List<TrainingCentre> trainingCentreList = new ArrayList<>();
		Iterable<TrainingCentre> allCentres = trainingCentreRepository.findAll();
		for (TrainingCentre trainingCentre : allCentres) {
			trainingCentreList.add(trainingCentre);
		}
		return trainingCentreList;
	}

	private boolean existByEmailId(TrainingCentre trainingCentre) {
		Optional<TrainingCentre> trainingCentreEmail = trainingCentreRepository.findByEmail(trainingCentre.getEmail());
		if (trainingCentreEmail.isPresent()) {
			return true;
		}
		return false;

	}

}

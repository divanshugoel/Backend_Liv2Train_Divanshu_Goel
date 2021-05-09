package org.liv2train.app.student.training.centre.locator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.liv2train.app.student.training.centre.locator.mapper.AddressMapper;
import org.liv2train.app.student.training.centre.locator.mapper.TrainingCentreMapper;
import org.liv2train.app.student.training.centre.locator.model.Address;
import org.liv2train.app.student.training.centre.locator.model.TrainingCentre;
import org.liv2train.app.student.training.centre.locator.repository.AddressRepository;
import org.liv2train.app.student.training.centre.locator.repository.TrainingCentreRepository;
import org.liv2train.app.student.training.centre.locator.request.dto.TrainingCentreRequestDTO;
import org.liv2train.app.student.training.centre.locator.service.TrainingCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingCentreServiceImpl implements TrainingCentreService {
	@Autowired
	TrainingCentreRepository trainingCentreRepository;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public TrainingCentre createTrainingCentre(TrainingCentreRequestDTO trainingCentreRequestDTO) {

		Address address = AddressMapper.mapToVO(trainingCentreRequestDTO.getAddress());

//		Address savedAddress = addressRepository.save(address);
		TrainingCentre trainingCentre = TrainingCentreMapper.mapToVO(trainingCentreRequestDTO);
		trainingCentre.setAddress(address);

		TrainingCentre savedtrainingCentre = trainingCentreRepository.save(trainingCentre);

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

}

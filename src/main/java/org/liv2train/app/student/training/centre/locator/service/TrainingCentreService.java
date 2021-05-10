package org.liv2train.app.student.training.centre.locator.service;

import java.util.List;

import org.liv2train.app.student.training.centre.locator.model.TrainingCentre;
import org.liv2train.app.student.training.centre.locator.request.dto.TrainingCentreRequestDTO;

public interface TrainingCentreService {
	
	public TrainingCentre createTrainingCentre(TrainingCentreRequestDTO trainingCentreRequestDTO) throws Exception;
	public List<TrainingCentre> getAllTrainingCentre();
	
}

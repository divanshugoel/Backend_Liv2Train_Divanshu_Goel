package org.liv2train.app.student.training.centre.locator.service;

import java.util.List;
import org.liv2train.app.student.training.centre.locator.model.TrainingCentre;
import org.liv2train.app.student.training.centre.locator.request.dto.TrainingCentreRequestDTO;

/**
 * TrainingCentreService is an interface for service operations for a specific result.
 * 
 * @author Divanshu_Goel
 */
public interface TrainingCentreService {
	/**
	 * creates new trainingCentre when trainingCentreRequestDTO is passed
	 * as a input parameter
	 *
	 * @see TrainingCentreServiceImpl
	 * @param trainingCentreRequestDTO {@link -> TrainingCentreRequestDTO}.
	 * @return TrainingCentre {@link -> TrainingCentre}.
	 * @throws AppException in case the TrainingCentreRequestDTO contains email that
	 * already exists. 
	 */
	public TrainingCentre createTrainingCentre(TrainingCentreRequestDTO trainingCentreRequestDTO) throws Exception;
	
	
	/**
	 * Returns all instances of the TrainingCentre in a list.
	 *
	 * @see TrainingCentreServiceImpl
	 * @return TrainingCentre {@link -> List}.
	 *
	 */
	public List<TrainingCentre> getAllTrainingCentre();
	
}

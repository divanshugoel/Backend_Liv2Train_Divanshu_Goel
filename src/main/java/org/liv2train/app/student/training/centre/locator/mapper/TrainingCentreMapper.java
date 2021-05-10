package org.liv2train.app.student.training.centre.locator.mapper;

import java.time.Instant;
import java.util.StringJoiner;

import org.liv2train.app.student.training.centre.locator.model.TrainingCentre;
import org.liv2train.app.student.training.centre.locator.request.dto.TrainingCentreRequestDTO;

/**
 * TrainingCentreMapper is a class that maps fields of model objects and request
 * objects
 * 
 * @author Divanshu_Goel
 *
 */
public class TrainingCentreMapper {
	/**
	 * mapToVO is a method that maps fields of trainingCentreRequestDTO object to
	 * trainingCentre object.
	 * 
	 * @see TrainingCentreServiceImpl
	 * @param trainingCentreRequestDTO {@link -> TrainingCentreRequestDTO}
	 * @return trainingCentre {@link -> TrainingCentre}
	 * @since 1.0
	 * @version 1.0
	 */
	public static TrainingCentre mapToVO(TrainingCentreRequestDTO trainingCentreRequestDTO) {
		TrainingCentre trainingCentre = new TrainingCentre();
		StringJoiner stringJoiner = new StringJoiner(",");
		trainingCentre.setCentreName(trainingCentreRequestDTO.getCentreName());
		trainingCentre.setCentreCode(trainingCentreRequestDTO.getCentreCode());
		trainingCentre.setCreatedOn(Instant.now());
		trainingCentre.setEmail(trainingCentreRequestDTO.getEmail());
		trainingCentre.setPhoneNumber(trainingCentreRequestDTO.getPhoneNumber());
		trainingCentre.setStudentCapacity(trainingCentreRequestDTO.getStudentCapacity());
		for (String courseName : trainingCentreRequestDTO.getCoursesOfferd()) {
			stringJoiner.add(courseName);
		}
		String courseList = stringJoiner.toString();
		trainingCentre.setCourses(courseList);
		return trainingCentre;

	}

}

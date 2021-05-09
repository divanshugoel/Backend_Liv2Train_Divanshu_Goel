package org.liv2train.app.student.training.centre.locator.mapper;

import java.time.Instant;
import java.util.StringJoiner;

import org.liv2train.app.student.training.centre.locator.model.TrainingCentre;
import org.liv2train.app.student.training.centre.locator.request.dto.TrainingCentreRequestDTO;

public class TrainingCentreMapper {

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

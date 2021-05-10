package org.liv2train.app.student.training.centre.locator.repository;

import java.util.Optional;

import org.liv2train.app.student.training.centre.locator.model.TrainingCentre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCentreRepository extends CrudRepository<TrainingCentre, Integer> {

	@Query("Select trainingCentre from TrainingCentre trainingCentre where trainingCentre.email =:email")
	Optional<TrainingCentre> findByEmail(String email);

	@Query("Select trainingCentre from TrainingCentre trainingCentre order by createdOn desc")
	Iterable<TrainingCentre> findAll();

}

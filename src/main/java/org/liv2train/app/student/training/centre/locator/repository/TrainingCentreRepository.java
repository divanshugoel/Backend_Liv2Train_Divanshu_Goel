package org.liv2train.app.student.training.centre.locator.repository;

import java.util.Optional;

import org.liv2train.app.student.training.centre.locator.model.TrainingCentre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



/**
 * TrainingCentreRepository is an interface for performing 
 * basic CRUD operations on a repository for a specific type.
 *  
 * @param <TrainingCentre> the domain type the repository manages
 * @param <Integer> the type of the id of the entity the repository manages
 * 
 * @author Divanshu_Goel
 */


@Repository
public interface TrainingCentreRepository extends CrudRepository<TrainingCentre, Integer> {
 	
	/**
	 * findByEmail is a method that retrieves a trainingCentre by its email.
	 * @param email {@link -> String}
	 * @return the trainingCentre with the given email or {@literal Optional#empty()} if none found.
	 * @since 1.0
	 * @version 1.0
	 */
	@Query("Select trainingCentre from TrainingCentre trainingCentre where trainingCentre.email =:email")
	public Optional<TrainingCentre> findByEmail(String email);
	
	/**
	 * findAllis a method that returns all instances of the trainingCentre 
	 * in descending order sorted by their time of creation  .
	 *
	 * @return all trainingCentre in a list
	 * since 1.0
	 * version 1.0
	 */
	@Query("Select trainingCentre from TrainingCentre trainingCentre order by createdOn desc")
	public Iterable<TrainingCentre> findAll();

}

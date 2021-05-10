package org.liv2train.app.student.training.centre.locator.repository;

import org.liv2train.app.student.training.centre.locator.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * AddressRepository is an interface for performing 
 * basic CRUD operations on a repository for a specific type.
 *  
 * @param <Address> the domain type the repository manages
 * @param <Integer> the type of the id of the entity the repository manages
 * 
 * @author Divanshu_Goel
 */


@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}

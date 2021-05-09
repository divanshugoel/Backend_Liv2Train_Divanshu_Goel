package org.liv2train.app.student.training.centre.locator.repository;

import org.liv2train.app.student.training.centre.locator.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}

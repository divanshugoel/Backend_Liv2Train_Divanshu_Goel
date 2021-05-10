package org.liv2train.app.student.training.centre.locator.mapper;

import org.liv2train.app.student.training.centre.locator.model.Address;
import org.liv2train.app.student.training.centre.locator.response.dto.AddressDTO;

/**
 * AddressMapper is a class that maps fields of model objects
 * and request objects 
 * 
 * @author Divanshu_Goel
 *
 */

public class AddressMapper {

	/**
	 * mapToVO is a method that maps fields of addressDTO object
	 * to address object.
	 * @see TrainingCentreServiceImpl
	 * @param addressDTO {@link -> AddressDTO}
	 * @return address {@link -> Address}
	 * @since 1.0
	 * @version 1.0
	 */
	public static Address mapToVO(AddressDTO addressDTO) {
		Address address = new Address();

		address.setDetailedAddress(addressDTO.getDetailedAddress());
		address.setPincode(addressDTO.getPincode());
		address.setState(addressDTO.getState());
		address.setCity(addressDTO.getCity());
		return address;
	}
	

}

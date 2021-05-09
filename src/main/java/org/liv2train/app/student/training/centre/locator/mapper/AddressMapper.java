package org.liv2train.app.student.training.centre.locator.mapper;

import org.liv2train.app.student.training.centre.locator.model.Address;
import org.liv2train.app.student.training.centre.locator.response.dto.AddressDTO;

public class AddressMapper {

	public static Address mapToVO(AddressDTO addressDTO) {
		Address address = new Address();

		address.setDetailedAddress(addressDTO.getDetailedAddress());
		address.setPincode(addressDTO.getPincode());
		address.setState(addressDTO.getState());
		address.setCity(addressDTO.getCity());
		return address;
	}
	

}

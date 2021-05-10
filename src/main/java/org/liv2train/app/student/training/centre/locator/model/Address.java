package org.liv2train.app.student.training.centre.locator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * Address is the POJO class for sending
 * address object to the TrainingCentre.
 * 
 * @author Divanshu_Goel
 * 
 */


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Address")
public class Address {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "detailedAddress")
	@NotNull(message = "centre address cannot be null ")
	@NotEmpty(message = "centre address cannot be empty ")
	private String detailedAddress;

	@Column(name = "city")
	@NotNull(message = "centre city cannot be null ")
	@NotEmpty(message = "centre city cannot be empty ")
	private String city;

	@Column(name = "state")
	@NotNull(message = "centre state cannot be null ")
	@NotEmpty(message = "centre state cannot be empty ")
	private String state;

	@Column(name = "pincode")
	@NotNull(message = "centre pincode cannot be null ")
	@NotEmpty(message = "centre pincode cannot be empty ")
	private String pincode;

}

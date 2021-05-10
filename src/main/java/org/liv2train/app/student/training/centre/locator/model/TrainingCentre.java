package org.liv2train.app.student.training.centre.locator.model;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * TrainingCentre is the POJO class of the trainingCentre model object
 * 
 * It sends trainingCentre object.
 * 
 * @author Divanshu_Goel
 * 
 */


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Training_Centre")
public class TrainingCentre {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_centre_seq")
	@SequenceGenerator(name = "training_centre_seq", sequenceName = "training_centre_seq_table")
	private Integer id;

	@Column(name = "centreName")
	@NotNull(message = "centre name cannot be null ")
	@NotEmpty(message = "centre name cannot be empty ")
	@Size(max = 40, message = "Centre name is too long")
	private String centreName;

	@Column(name = "centreCode")
	@NotNull(message = "centre code cannot be null ")
	@NotEmpty(message = "centre code cannot be empty ")
	@Pattern(regexp = "^[\\p{Alnum}]{1,12}$", message = "invalid centre code")
	private String centreCode;

	@Column(name = "studentCapacity")
	private Integer studentCapacity;

	@Column(name = "courses")
	private String courses;

	@NotNull(message = "centre address cannot be null ")

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	@Column(name = "createdOn")
	private Instant createdOn;

	@Email(message = "Please enter a valid email id")
	@Column(name = "email")
	private String email;

	@Column(name = "phoneNumber")
	@NotNull(message = "centre contact details cannot be null ")
	@NotEmpty(message = "centre contact details be empty ")
	@Pattern(regexp = "^[7-9][0-9]{9}$", message = "Please enter a valid phone number")
	private String phoneNumber;

}

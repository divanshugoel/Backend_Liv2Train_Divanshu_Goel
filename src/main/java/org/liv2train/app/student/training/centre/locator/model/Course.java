//package org.liv2train.app.student.training.centre.locator.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "Course")
//public class Course {
//	@Column(name = "id")
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;
//	
//	@Column(name = "courseName")
//	private String courseName;
//
//	@ManyToOne
//	@JoinColumn(name = "training_centre_id", referencedColumnName = "id")
//	private TrainingCentre trainingCentre;
//}

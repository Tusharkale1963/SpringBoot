package com.student.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class StudentEntity {

	@Id
	@GeneratedValue(generator = "student_id")
	@SequenceGenerator(name="student_id",sequenceName = "student_id_seq")
	private Integer id;
	private String name ;
	private String address;
	private String std;
	private String schoolName;
	private String mobileNum ;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "student_id", referencedColumnName = "mark_Id")
	private MarkSheet marksheet;
	   
	
}

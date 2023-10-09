package com.student.entity;

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
public class MarkSheet {

	@Id
	private Integer mark_Id;
	private Double marathi;
	private Double english;
	private Double hindi;
	private Double math;
	private Double geography;
	private Double history;
	
	
	
}




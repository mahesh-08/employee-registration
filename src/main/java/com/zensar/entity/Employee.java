package com.zensar.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String name;
	private long mobile;
	private String email;
	private int passOutYear;
	private String currentProject;
	private String fresher;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",lenient = OptBoolean.FALSE)
	private Date joiningDate;
	
}

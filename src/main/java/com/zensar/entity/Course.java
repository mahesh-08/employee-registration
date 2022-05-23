package com.zensar.entity;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int courseid;
	private String courseName;
	private String trainerName;
	private Date startDate;
	private Date endDate;
	private String timing;
	private int duration;
	private int capacity;
	private int availableSeats;
	private int activeStatus;
	
}

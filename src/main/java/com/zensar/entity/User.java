package com.zensar.entity;


import java.util.Date;
import java.time.LocalTime;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String token;
	private String password;
	private Date loginDate;
	private int activeStatus;
	//private LocalTime timestamp;
}

package com.zensar.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Course;
import com.zensar.entity.ResponseEntity;
import com.zensar.entity.StatusDO;
import com.zensar.exception.InvalidTokenException;
import com.zensar.service.CourseService;

@RestController
public class CourseControllerImpl implements CourseController {
	@Autowired
	CourseService courseService;

	@Override
	public ResponseEntity addCourse(Map<String, String> header, Course course) {
		try {
			courseService.validateToken(header.get("token"));
			Course addCourse = courseService.addCourse(course);
			return new ResponseEntity("Add course", addCourse, new StatusDO(1, "Course added "));
		} catch (Exception  e) {
			return new ResponseEntity("Add course", null, new StatusDO(-1, e.getMessage()));
		}
		
	}

	@Override
	public ResponseEntity getCourse(Map<String, String> header, String courseName) {
		Course course = courseService.getCourse(courseName);
		
		return new ResponseEntity("Get course", course, new StatusDO(1, "Course fetched "));
	}

	@Override
	public ResponseEntity getCourseList(Map<String, String> header) {
		List<String> courseList = courseService.getCourseList();
		return new ResponseEntity("Get course", courseList, new StatusDO(1, "Course list fetched "));
	}

	@Override
	public ResponseEntity getAvailableSeats(Map<String, String> header, int id) {
		int availableSeats = courseService.getAvailableSeats(id);
		return  new ResponseEntity("Get available seats", availableSeats, new StatusDO(1, "Avaialble seats fetched "));
	}

	@Override
	public ResponseEntity applyForCourse(Map<String, String> header) {
		int empId=Integer.parseInt(header.get("empid"));
		int courseId=Integer.parseInt(header.get("courseid"));
		courseService.applyForCourse(empId,courseId);
		return null;
	}

}

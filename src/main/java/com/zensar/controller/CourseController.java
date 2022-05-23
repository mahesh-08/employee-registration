package com.zensar.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zensar.entity.Course;
import com.zensar.entity.ResponseEntity;

@RequestMapping("course")
public interface CourseController {
	@PostMapping("/add")
	public ResponseEntity addCourse(@RequestHeader Map<String, String> header,@RequestBody Course course);
	@GetMapping("/get/{courseName}")
	public ResponseEntity getCourse(@RequestHeader Map<String, String> header,@PathVariable String courseName);
	@GetMapping("/all")
	public ResponseEntity getCourseList(@RequestHeader Map<String, String> header);
	@GetMapping("/seats/{id}")
	public ResponseEntity getAvailableSeats(@RequestHeader Map<String, String> header,@PathVariable int id);
	@GetMapping("/apply/{id}")
	public ResponseEntity applyForCourse(@RequestHeader Map<String, String> header);
}

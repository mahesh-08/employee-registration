package com.zensar.service;

import java.util.List;

import com.zensar.entity.Course;

public interface CourseService {

	public Course addCourse(Course course);

	public Course getCourse(String courseName);

	public List<String> getCourseList();

	public int getAvailableSeats(int id);

	public void applyForCourse(int empId,int courseid);

	public void validateToken(String token);
}

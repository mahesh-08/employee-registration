package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.Course;
import com.zensar.entity.User;
import com.zensar.exception.CourseExistException;
import com.zensar.exception.InvalidTokenException;
import com.zensar.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private UserService userService;

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course addCourse(Course course) {
		if(courseRepository.findByCourseName(course.getCourseName())==null)
			throw new CourseExistException("Course already exist");
		course.setActiveStatus(1);
		return courseRepository.save(course);
	}

	@Override
	public Course getCourse(String courseName) {
		
		return courseRepository.findByCourseName(courseName);
	}

	@Override
	public List<String> getCourseList() {
		
		return courseRepository.findCourseName();
	}

	@Override
	public int getAvailableSeats(int id) {
		
		return courseRepository.findById(id).get().getAvailableSeats();
	}

	@Override
	public void applyForCourse(int empId,int courseid) {
		

	}

	public void validateToken(String token) {
		// String token=header.get("token");
		if (token == null)
			throw new InvalidTokenException("No token");
		User user = userService.validateToken(token);
		if (user == null)
			throw new InvalidTokenException("Invalid token");
	}

}

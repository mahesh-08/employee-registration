package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zensar.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	public Course findByCourseName(String courseName);

	@Query(value = "select course_name from course", nativeQuery = true)
	public List<String> findCourseName();
}

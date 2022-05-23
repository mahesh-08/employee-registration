package com.zensar.service;

import java.util.List;

import com.zensar.entity.Employee;

public interface EmpService {
	public Employee addEmp(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee getEmployee(int id);
	public void deleteEmployee(int id);
	public void validateToken(String token);
}

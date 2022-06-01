package com.zensar.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import com.zensar.entity.Employee;
import com.zensar.entity.ResponseEntity;
import com.zensar.entity.StatusDO;
import com.zensar.exception.AddEmployeeException;
import com.zensar.exception.EmployeeWithIdException;
import com.zensar.exception.InvalidTokenException;
import com.zensar.service.EmpService;

@RestController
public class EmpControllerImpl implements EmpController {

	@Autowired
	private EmpService empService;

	// private Employee employee;

	@Override
	public ResponseEntity addEmployee(Map<String, String> header, Employee employee) {

		try {
			empService.validateToken(header.get("token"));
			Employee emp = empService.addEmp(employee);
			return new ResponseEntity("Add Employee", emp, new StatusDO(200, "Employee added"));
		} catch (AddEmployeeException | InvalidTokenException e) {
			return new ResponseEntity("Add Employee", null, new StatusDO(-1, e.getMessage()));
		}

	}

	@Override
	public ResponseEntity getEmployee(Map<String, String> header, int id) {
		try {
			empService.validateToken(header.get("token"));
			Employee employee = empService.getEmployee(id);
			return new ResponseEntity("Get Employee", employee, new StatusDO(200, HttpStatus.OK.name()));
		} catch (EmployeeWithIdException | InvalidTokenException e) {
			return new ResponseEntity("Get Employee", null, new StatusDO(400, e.getMessage()));
		}
	}

	@Override
	public ResponseEntity getAllEmployee(Map<String, String> header) {
		try {
			empService.validateToken(header.get("token"));
			List<Employee> allEmployee = empService.getAllEmployee();
			return new ResponseEntity("Get all Employee", allEmployee, new StatusDO(200, HttpStatus.OK.name()));
		} catch (InvalidTokenException e) {
			return new ResponseEntity("Get all Employee", null, new StatusDO(-1, e.getMessage()));
		}
	}

	@Override
	public ResponseEntity deleteEmployee(Map<String, String> header, int id) {
		try {
			empService.validateToken(header.get("token"));
			empService.deleteEmployee(id);
			return new ResponseEntity("Delete Employee", null, new StatusDO(200, "Delete success"));
		} catch (EmployeeWithIdException | InvalidTokenException e) {
			return new ResponseEntity("Delete Employee", null, new StatusDO(400, e.getMessage()));
		}
	}
}

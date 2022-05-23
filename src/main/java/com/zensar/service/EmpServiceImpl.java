package com.zensar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.common.Attribute;
import com.zensar.entity.Employee;
import com.zensar.entity.ResponseEntity;
import com.zensar.entity.StatusDO;
import com.zensar.entity.User;
import com.zensar.exception.AddEmployeeException;
import com.zensar.exception.EmployeeWithIdException;
import com.zensar.exception.InvalidTokenException;
import com.zensar.repository.EmployeeRepository;
import com.zensar.validator.Validator;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	Validator validator;
	@Autowired
	private UserService userService;
	

	@Override
	public Employee addEmp(Employee employee) {
		Optional<Employee> dbEMployee = repository.findById(employee.getEmpId());
		if(dbEMployee.isPresent())
			throw new AddEmployeeException("Employee with id exist");
		if (!validator.validate(employee.getEmail(), Attribute.EMAIL))
			throw new AddEmployeeException("Invalid email ");
		if (!validator.validate(Long.toString(employee.getMobile()), Attribute.MOBILE))
			throw new AddEmployeeException("Invalid Mobile ");

		return repository.save(employee);

	}

	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> listOfEmployees = repository.findAll();

		// listOfEmployees.stream().forEach(Employee -> System.out.println(Employee));
		//listOfEmployees.stream().forEach(System.out::println);
		return listOfEmployees;
	}

	@Override
	public Employee getEmployee(int id) {		
		return repository.findById(id).orElseThrow(()-> new EmployeeWithIdException("No Employee with id " + id));
	}
	

	@Override
	public void deleteEmployee(int id) {
		if(repository.existsById(id))
			repository.deleteById(id);
		else 
			throw new EmployeeWithIdException("No Employee to delete with id " + id);	
	}
	
	public void validateToken(String token) {
		//String token=header.get("token");
		if(token==null)
			throw new InvalidTokenException("No token");
		User user = userService.validateToken(token);
		if(user==null)
			throw new InvalidTokenException("Invalid token");
	}

}

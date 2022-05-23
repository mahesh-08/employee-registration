package com.zensar.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.zensar.entity.Employee;
import com.zensar.entity.ResponseEntity;

@RequestMapping("employee")
public interface EmpController {
	@PostMapping("/add")
	public ResponseEntity  addEmployee(@RequestHeader Map<String, String> header,@RequestBody Employee employee);

	@GetMapping("/{id}")
	public ResponseEntity getEmployee(@RequestHeader Map<String, String> header,@PathVariable int id);

	@GetMapping("/all")
	public ResponseEntity getAllEmployee(@RequestHeader Map<String, String> header);
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteEmployee(@RequestHeader Map<String, String> header,@PathVariable int id);
}

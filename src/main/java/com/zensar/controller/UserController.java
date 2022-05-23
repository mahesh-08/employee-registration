package com.zensar.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zensar.entity.ResponseEntity;

@RequestMapping("user")
public interface UserController {

	@PostMapping("/login")
	public ResponseEntity loginUser(@RequestHeader Map<String, String> header);

	@PostMapping("/logout")
	public ResponseEntity logOut(@RequestHeader Map<String, String> header);

	@PostMapping("/signup")
	public ResponseEntity signup(@RequestHeader Map<String, String> header);

	@GetMapping("/welcome")
	public String welcome();
}

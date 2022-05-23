package com.zensar.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.common.CommonMethods;
import com.zensar.entity.ResponseEntity;
import com.zensar.entity.StatusDO;
import com.zensar.entity.User;
import com.zensar.exception.InvalidCredentialsException;
import com.zensar.exception.UserExistExecption;
import com.zensar.service.UserService;

@RestController
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;

	@Override
	public ResponseEntity loginUser(Map<String, String> header) {
		User user = null;
		
		if(header.get("token")!=null) {
			user=userService.validateToken(header.get("token"));
			if(user!=null) 
				return new ResponseEntity("loginUser", user.getToken(), new StatusDO(200, HttpStatus.OK.name()));
			else
				return new ResponseEntity("loginUser", null, new StatusDO(400, "Invalid Token"));
		}
		
		try {
			user = CommonMethods.getUser(header);
		} catch (InvalidCredentialsException e) {
			return new ResponseEntity("loginUser", null, new StatusDO(401, e.getMessage()));
		}
				
		
		user.setToken(userService.loginUser(user));
		if (user.getToken() != null) {
			return new ResponseEntity("loginUser", user.getToken(), new StatusDO(200, HttpStatus.OK.name()));
		} else
			return new ResponseEntity("loginUser",null , new StatusDO(401, "No user Found"));

	}

	@Override
	public ResponseEntity logOut(Map<String, String> header) {
		//System.out.println(header.get("token"));
		int rowcount = userService.logOut(header.get("token"));
		if(rowcount>0)
			return new ResponseEntity("logOut",null , new StatusDO(200, "logout successful"));
		else
			return new ResponseEntity("logOut",null , new StatusDO(401, "logout error"));
	}

	@Override
	public String welcome() {
		return "welcome";
	}

	@Override
	public ResponseEntity signup(Map<String, String> header) {

		try {
			User user = CommonMethods.getUser(header);
//			if (user.getPassword() == null) {
//				return new ResponseEntity("signup", null, new StatusDO(400, "Invalid password"));
//			}
			if (userService.signupUser(user) != null) {
				return new ResponseEntity("signup",null , new StatusDO(200, "Signup successfull"));
			} else
				return new ResponseEntity("signup",null ,
						new StatusDO(401, "Problem in user signup"));
		} catch (Exception e) {
			return new ResponseEntity("signup", null, new StatusDO(401, e.getMessage()));
		}
	}

}

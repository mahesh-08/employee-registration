package com.zensar.common;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.zensar.entity.ResponseEntity;
import com.zensar.entity.StatusDO;
import com.zensar.entity.User;
import com.zensar.exception.InvalidCredentialsException;
import com.zensar.validator.Validator;

public class CommonMethods {

	
	
	public static String encrypt(String message) {
		final String alpha = "abcdefghijklmnopqrstuvwxyz";
		final int shiftkey= 32;
		message = message.toLowerCase();
		String encrypt = "";
		char replaceChar;
		for (int i = 0; i < message.length(); i++) {
			 char ch = message.charAt(i);
			if(ch >= 'a' && ch <= 'z'|| ch >= 'A' && ch <= 'Z') {
				int charPosition = alpha.indexOf(message.charAt(i));
				int keyValue = (shiftkey + charPosition) % 26;
				replaceChar = alpha.charAt(keyValue);
			}
			else {
				replaceChar=ch;
			}
			encrypt += replaceChar;
		}
		return encrypt;
	}
	
	public static User getUser(Map<String, String> header) {
		User user=new User();
		user.setUserName(header.get("username"));
		user.setPassword(header.get("password"));
		//System.out.println(user);
		if(user.getUserName()==null || user.getPassword()==null) {
			throw new InvalidCredentialsException("Provide user name and password");
		}
		return user;
	}
}

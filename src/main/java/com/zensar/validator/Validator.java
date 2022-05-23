package com.zensar.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.zensar.common.Attribute;

@Service
public class Validator {

	// private static Validator validator;
	private Pattern pattern;
	private Matcher matcher;
	private String regex;
	private Map<Attribute, String> regexMap = new HashMap<>();

	public Validator() {
		regexMap.put(Attribute.EMAIL, "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}");
		regexMap.put(Attribute.MOBILE, "^\\d{10}$");
	}

	public boolean validate(String value, Attribute inputType) {

		regex = regexMap.get(inputType);
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(value);
		return matcher.matches();

		// regexMap.entrySet().stream().flatMap(e ->inputType.compareTo(e.getKey()));

		//return false;

	}
}

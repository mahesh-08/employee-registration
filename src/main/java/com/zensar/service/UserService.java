package com.zensar.service;

import com.zensar.entity.User;

public interface UserService {

	public String loginUser(User user);
	public int logOut(String token);
	public User validateToken(String token);
	public User signupUser(User user);
}

package com.zensar.service;

import java.util.Date;
import java.util.Optional;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.common.CommonMethods;
import com.zensar.common.Token;
import com.zensar.entity.User;
import com.zensar.exception.UserExistExecption;
import com.zensar.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public String loginUser(User user) {
		String token = null;
		String encodedPassword = CommonMethods.encrypt(user.getPassword());
		user.setPassword(encodedPassword);
		User dbUser = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		if (dbUser != null) {
			if(dbUser.getToken()!=null)
				return dbUser.getToken();
			token = Token.generateToken();
			userRepository.updateToken(dbUser.getUserId(),token,new Date());
		}
		return token;
	}

	@Override
	public int logOut(String token) {
		int deleteToken = userRepository.deleteToken(token);
		
		
		//User user = userRepository.findByToken(token);
		//int deleteToken = userRepository.deleteToken(user.getUserId());
		return deleteToken;
	}

	@Override
	public User validateToken(String token) {
		return userRepository.findByToken(token);

	}

	@Override
	public User signupUser(User user) {
		user.setPassword(CommonMethods.encrypt(user.getPassword()));
		//user.setLoginDate(new Date());
		user.setActiveStatus(1);
		//user.setTimestamp(LocalTime.now());
		Optional<User> dbUser = userRepository.findByUserName(user.getUserName());
		if(dbUser.isPresent())
			throw new UserExistExecption("User exist with user name "+user.getUserName());
		return userRepository.save(user);
	}

}

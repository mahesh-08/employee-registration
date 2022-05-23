//package com.zensar.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
////import com.zensar.entity.User;
//import com.zensar.repository.UserRepository;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService{
//
//	
//	@Autowired
//	UserRepository	userRepository;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<com.zensar.entity.User> user = userRepository.findByUserName(username);
//		//System.out.println("inside UserDetailsServiceImpl");
//		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
//		
//		authorities.add(new SimpleGrantedAuthority("user"));
//		return new User(user.get().getUserName(),user.get().getPassword(),authorities);
//	}
//
//}

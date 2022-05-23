package com.zensar.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.zensar.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserNameAndPassword(String userName, String password);
	@Modifying
	@Transactional
	@Query(value = "update user set token=:token,login_date=:loginDate where user_id=:id", nativeQuery = true)
	public void updateToken(@Param("id") int id, @Param("token") String token,@Param("loginDate") Date loginDate);

	@Modifying
	@Transactional
	@Query(value = "update user set token=null, login_date=null where token=:token", nativeQuery = true)
	public int deleteToken(@Param("token") String token);

//	@Query(value = "update user set token=null where user_name=:userName and token=:token", nativeQuery = true)
//	public void deleteToken(@Param("userName") String userName, @Param("token") String token);
	
//	@Modifying
//	@Transactional
//	@Query(value = "update user set token=null,login_date=null where user_id=:id", nativeQuery = true)
//	public int deleteToken(@Param("id") int id);
	
	
	public Optional<User> findByUserName(String userName);
	
	//public User findByUserNameAndToken(String userNmae,String token);
	public User findByToken(String token);
}

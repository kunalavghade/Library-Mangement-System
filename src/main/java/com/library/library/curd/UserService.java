package com.library.library.curd;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.library.entities.User;

public interface UserService extends JpaRepository<User, Integer>{
	
	@Query("FROM User AS u WHERE u.isenable = :isenable")
	public List<User> getUsers(@Param("isenable") boolean isenable);
	

	@Query("FROM User AS u WHERE u.isenable = :isenable")
	public Page<User> getUsers(@Param("isenable") boolean isenable,Pageable p);
	
}

package com.library.library.curd;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.library.entities.User;

public interface UserService extends JpaRepository<User, Integer>{
	
	@Query("FROM User AS u WHERE u.isenable = TRUE")
	public List<User> getUsers();
	

	@Query("FROM User AS u WHERE u.isenable = TRUE")
	public Page<User> getUsers(Pageable p);
}

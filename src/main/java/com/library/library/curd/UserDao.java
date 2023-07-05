package com.library.library.curd;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library.library.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

}

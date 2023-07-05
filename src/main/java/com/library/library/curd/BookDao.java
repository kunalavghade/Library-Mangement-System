package com.library.library.curd;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library.entities.Book;

public interface BookDao extends JpaRepository<Book, Integer>{

}

package com.library.library.curd;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.library.library.entities.Book;

public interface BookService extends JpaRepository<Book, Integer>{
	
	
	@Query("FROM Book AS  b WHERE b.active = TRUE")
	public List<Book> getBooks();
	
	@org.springframework.data.jpa.repository.Modifying
	@Transactional
	@Query("UPDATE Book AS b SET b.active = :active WHERE b.id = :id")
	public void setStatus(@Param("id") int id,@Param("active") boolean active);
	
	@Query("FROM Book AS  b WHERE b.active = TRUE")
	public Page<Book> getBooks(Pageable p);
	
	public List<Book> findTop5ByOrderByDateDesc();
	
}

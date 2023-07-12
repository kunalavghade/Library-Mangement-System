package com.library.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.curd.BookService;
import com.library.library.entities.Book;


@RestController
@RequestMapping("/Book")
public class BookController {
	
	@Autowired
	private BookService bookServices;
	
	
	
	@GetMapping("/")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = this.bookServices.getBooks();
		if(books.size() <= 0) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(books));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable int id) {
		try {
			Book book = this.bookServices.findById(id).get();
			return ResponseEntity.of(Optional.of(book));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	
	@PostMapping("/")
	public ResponseEntity<Book> getBooks(@RequestBody Book book) {
		try {
			Book b = this.bookServices.save(book);
			return ResponseEntity.of(Optional.of(b));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> getBooks(@PathVariable int id) {
		try {
			this.bookServices.findById(id).get();
			this.bookServices.setStatus(id, false);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
	}
	
	@GetMapping("/page/{num}")
	public ResponseEntity<Page<Book>> getBooksByPage(@PathVariable int num) {
		try {
			Page<Book> page = this.bookServices.getBooks(PageRequest.of(num, 7));
			return ResponseEntity.of(Optional.of(page));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/recent")
	public ResponseEntity<List<Book>> getBooksByPage() {
		try {
			List<Book> page = this.bookServices.findTop5ByOrderByCreatedDateDesc();
			return ResponseEntity.of(Optional.of(page));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		try {
			int id = book.getId();
			
			Book b = this.bookServices.findById(id).get();
			if(book.getName() != null) b.setName(book.getName());
			if(book.getAuthor() != null) b.setAuthor(book.getAuthor());
			if(book.getAvailable() != -1) b.setAvailable(book.getAvailable());
			if(book.getType() != null) b.setType(book.getType());
			
			this.bookServices.save(b);
			b = this.bookServices.findById(id).get();
			return ResponseEntity.of(Optional.of(b));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}	
}	

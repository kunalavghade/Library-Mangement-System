package com.library.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

	Logger logger = LoggerFactory.getLogger(LibraryApplication.class);
			
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
	

}

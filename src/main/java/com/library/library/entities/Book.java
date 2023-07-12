package com.library.library.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name="Book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="author")
	private String author;
	
	@Column(name="name")
	private String name;
	
	@Column(name="total")
	private int total;
	
	@Column(name="available")
	private int available;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="created_date")
	@CreationTimestamp()
	private LocalDateTime createdDate;
	
	@Column(name="updated_date")
	@UpdateTimestamp()
	private LocalDateTime updatedDate;
	
}

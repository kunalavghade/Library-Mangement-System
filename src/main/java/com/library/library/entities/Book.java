package com.library.library.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String type;
	private String author;
	private String name;
	private int total;
	private int available;
	private boolean active;
	private LocalDate date;
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Book update(Book b) {
		if(b.getAuthor() != null) 
			this.author = b.getAuthor();
		if(b.getAvailable() != -1)
			this.available = b.getAvailable();
		if(b.getType() != null)
			this.type = b.getType();
		if(b.getName() != null)
			this.name = b.getName();
		return this;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", type=" + type + ", author=" + author + ", name=" + name + ", total=" + total
				+ ", available=" + available + ", active=" + active + ", date=" + date + "]";
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
}

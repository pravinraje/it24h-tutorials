package com.sstvn.ct4.alert.core.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nameBook;
	private Boolean completed;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameBook() {
		return nameBook;
	}
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public Book(String nameBook, Boolean completed) {
		super();
		this.nameBook = nameBook;
		this.completed = completed;
	}
	public Book() {
		super();
	}	
	@Override
	public String toString() {
		return String.format("Book [id=%s, nameBook=%s, completed=%s]", id,
				nameBook, completed);
	}
}

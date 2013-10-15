package com.sstvn.ct4.alert.core.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String schoolName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Student() {
		super();
	}
	public Student(String name, String schoolName) {
		super();
		this.name = name;
		this.schoolName = schoolName;
	}
	@Override
	public String toString() {
		return String.format("Student [id=%s, name=%s, schoolName=%s]", id,
				name, schoolName);
	}
	
}

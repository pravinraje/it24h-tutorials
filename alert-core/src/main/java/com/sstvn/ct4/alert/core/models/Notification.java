package com.sstvn.ct4.alert.core.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String notification;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	@Override
	public String toString() {
		return String.format("Notification [id=%s, notification=%s]", id,
				notification);
	}
	public Notification(String notification) {
		super();
		this.notification = notification;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

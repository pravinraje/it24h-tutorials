package com.sstvn.ct4.alert.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sstvn.ct4.alert.core.models.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	public List<Notification> findAllById(Long id);
}

package com.sstvn.ct4.alert.web.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sstvn.ct4.alert.core.models.Notification;
import com.sstvn.ct4.alert.core.repositories.NotificationRepository;

@Controller
@RequestMapping("/notification")
public class NotificationController {
	@Autowired NotificationRepository notificationRepository;
	
	@RequestMapping("/fixtures")
	public @ResponseBody String notificationFixtures() {
		notificationRepository.save(new Notification("New user registered. Just now"));
		notificationRepository.save(new Notification("Server #12 overloaded. 15 mins"));
		notificationRepository.save(new Notification("Application error. 40 mins"));
		return "OK";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Notification> listNotification() {
		return notificationRepository.findAll();	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody String createNotification(@RequestBody Notification notification, BindingResult rerult) {
		notificationRepository.save(notification);
		return "OK";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT) 
	public @ResponseBody String uodateNotification(@PathVariable Long id, @RequestBody Notification notification, BindingResult result) {
		notification.setId(id);
		notificationRepository.save(notification);
		return "OK";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE) 
	public @ResponseBody void deleteNotification(@PathVariable Long id) {
		notificationRepository.delete(id);
	}
	
	//----------------------------------------------------------------
	
}

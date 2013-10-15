package com.sstvn.ct4.alert.core.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	public String sayHello(String name) {
		return String.format("Hello %s!", name);
	}
}

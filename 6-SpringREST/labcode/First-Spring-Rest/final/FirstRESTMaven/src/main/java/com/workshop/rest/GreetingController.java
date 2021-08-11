package com.workshop.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	int myNum = 0;

	@GetMapping("/greeting")
	public Greeting sayHello() {
		
		return new Greeting(myNum++, "Hello from Spiderman !");
	}
}
package com.workshop.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BootConfigAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BootConfigAppApplication.class, args);
	}

}

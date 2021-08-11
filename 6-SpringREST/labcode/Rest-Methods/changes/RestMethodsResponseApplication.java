package com.workshop.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestMethodsResponseApplication {
  
  @Bean
  public Employee employee() {
    Employee myEmployee = new Employee("Thor", 300, false, resume());
    return myEmployee;
  }

  @Bean
  public Resume resume() {

    String[] spokenLanguages = {"English","French","Japanese"};
    Resume myResume = new Resume("Harvard",3.55f, spokenLanguages, "Awesome Developer", 5);
    return myResume;
  
  }  

	public static void main(String[] args) {
		SpringApplication.run(RestMethodsResponseApplication.class, args);
	}

}

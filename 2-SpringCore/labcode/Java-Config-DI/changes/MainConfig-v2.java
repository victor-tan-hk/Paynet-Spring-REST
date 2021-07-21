package com.workshop.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {
  
  @Bean
  public Exercise swimmingExercise() {
    return new SwimmingExercise();
  }
  
  @Bean
  public Exercise joggingExercise() {
    return new JoggingExercise();
  }
  
  // define bean AND inject dependency 
  @Bean
  public Student collegeStudent() {
    CollegeStudent myCollegeStudent = new CollegeStudent(joggingExercise());
    return myCollegeStudent;
  }

}
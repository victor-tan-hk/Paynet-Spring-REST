package com.workshop.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:highschool.properties")
public class MainConfig {
  
  @Bean
  public Exercise swimmingExercise() {
    return new SwimmingExercise();
  }
  
  @Bean
  public Exercise joggingExercise() {
    return new JoggingExercise();
  }
  
  @Bean
  @Primary
  public Exercise cyclingExercise() {
    return new CyclingExercise();
  }
  
  
  // define bean AND inject dependency 
  @Bean
  public Student highSchoolStudent() {
    HighSchoolStudent myHighSchoolStudent = new HighSchoolStudent(joggingExercise());
    return myHighSchoolStudent;
  }

}
package com.workshop.javaconfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.workshop.javaconfig")
@PropertySource("classpath:highschool.properties")
public class MainConfig {
  
  @Bean(name = "greatExercise")
  public Exercise swimmingExercise() {
    return new SwimmingExercise();
  }
  
  @Bean(name = "funExercise")
  public Exercise joggingExercise() {
    return new JoggingExercise();
  }
  
  @Bean(name = "coolExercise")
  public Exercise cyclingExercise() {
    return new CyclingExercise();
  }
  
  @Bean 
  public List<String> favouritePlaces() {
    List<String> myPlaces = new ArrayList<String>();
    myPlaces.add("New York");
    myPlaces.add("Paris");
    myPlaces.add("London");
    return myPlaces;
    
  }
  
  @Bean 
  public Map<String, Integer> subjectMarks() {
    Map<String, Integer> myMarks = new HashMap<String, Integer>(); 
    myMarks.put("Maths", 72);
    myMarks.put("Science", 85);
    myMarks.put("History", 39);
    return myMarks;
  }
  
}
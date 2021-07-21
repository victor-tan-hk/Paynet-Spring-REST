package com.workshop.javaconfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CollegeStudent implements Student {
  
  @Autowired
  @Qualifier("coolExercise")
  private Exercise myExercise;
  
  @Autowired
  private List<String> favouritePlaces;
  
  @Autowired
  private Map<String, Integer> subjectMarks;  
  

  public List<String> getFavouritePlaces() {
    return favouritePlaces;
  }

  public Map<String, Integer> getSubjectMarks() {
    return subjectMarks;
  }  


  public Exercise getMyExercise() {
    return myExercise;
  }

  @Override
  public void dailyActivity() {
    System.out.println ("Going to college : ");
    myExercise.doExercise();
  }

  
}

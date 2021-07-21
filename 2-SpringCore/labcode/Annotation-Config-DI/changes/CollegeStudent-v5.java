package com.workshop.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollegeStudent implements Student {

  @Autowired
  private Exercise cyclingExercise;
  
  public Exercise getCyclingExercise() {
    return cyclingExercise;
  }

  @Override
  public void dailyActivity() {
    System.out.println ("Going to college : ");
    cyclingExercise.doExercise();
  }

  
}

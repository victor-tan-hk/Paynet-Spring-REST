package com.workshop.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollegeStudent implements Student {

  private Exercise myExercise;
  
  @Autowired
  public CollegeStudent(Exercise myExercise) {
    this.myExercise = myExercise;
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

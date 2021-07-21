package com.workshop.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollegeStudent implements Student {

  private Exercise myExercise;
  
  public CollegeStudent() {
    System.out.println ("Default constructor called");
  }
  
  @Autowired
  public void setMyExercise(Exercise myExercise) {
    System.out.println ("Setter called");
    this.myExercise = myExercise;
  }
  
  @Autowired
  public void randomMethod1(Exercise myExercise) {
    System.out.println ("randomMethod1 called");
  }

  @Autowired
  public void randomMethod2(Exercise myExercise) {
    System.out.println ("randomMethod2 called");
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

package com.workshop.configdi;

public class CollegeStudent implements Student {

  private Exercise myExercise;

  // constructor for DI
  public CollegeStudent(Exercise myExercise) {
    this.myExercise = myExercise;
  }
  
  @Override
  public void dailyActivity() {
    System.out.println ("Going to college is awesome !");
    myExercise.doExercise();
  }
  
}

package com.workshop.javaconfig;


public class CollegeStudent implements Student {

  private Exercise myExercise;
  
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

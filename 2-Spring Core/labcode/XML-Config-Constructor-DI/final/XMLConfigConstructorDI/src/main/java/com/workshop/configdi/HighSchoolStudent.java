package com.workshop.configdi;

public class HighSchoolStudent implements Student {
  
  private Exercise myExercise;

  // constructor for DI
  public HighSchoolStudent(Exercise myExercise) {
    this.myExercise = myExercise;
  }
  
  @Override
  public void dailyActivity() {
    System.out.println ("Going to high school is boring !");
    myExercise.doExercise();
  }


}

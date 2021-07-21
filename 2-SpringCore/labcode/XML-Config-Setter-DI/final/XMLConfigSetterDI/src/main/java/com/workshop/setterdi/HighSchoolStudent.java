package com.workshop.setterdi;

public class HighSchoolStudent implements Student {
  
  private Exercise myExercise;

  // Setter method for DI
  public void setMyExercise(Exercise myExercise) {
    this.myExercise = myExercise;
  }
  
  public Exercise getMyExercise() {
    return myExercise;
  }

  @Override
  public void dailyActivity() {
    System.out.println ("Going to high school is boring !");
    myExercise.doExercise();
  }


}

package com.workshop.literal;

public class CollegeStudent implements Student {

  private Exercise myExercise;
  private String collegeName;
  private String degreeName;

  // Setter method for DI
  public void setCollegeName(String collegeName) {
    this.collegeName = collegeName;
  }

  // Setter method for DI
  public void setDegreeName(String degreeName) {
    this.degreeName = degreeName;
  }  

  // Setter method for DI
  public void setMyExercise(Exercise myExercise) {
    this.myExercise = myExercise;
  }
  
  public String getCollegeName() {
    return collegeName;
  }

  public String getDegreeName() {
    return degreeName;
  }

  public Exercise getMyExercise() {
    return myExercise;
  }

  @Override
  public void dailyActivity() {
    System.out.println ("Going to college : " + collegeName);
    System.out.println ("Studying for a degree in  : " + degreeName);
    myExercise.doExercise();
  }
  
}

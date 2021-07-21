package com.workshop.literal;

public class CollegeStudent implements Student {

  private Exercise myExercise;
  private String collegeName;
  private float CGPA;

  // Setter method for DI
  public void setCollegeName(String collegeName) {
    this.collegeName = collegeName;
  }

  // Setter method for DI
  public void setCGPA(float cGPA) {
    CGPA = cGPA;
  }  

  // Setter method for DI
  public void setMyExercise(Exercise myExercise) {
    this.myExercise = myExercise;
  }
  
  public String getCollegeName() {
    return collegeName;
  }

  public Exercise getMyExercise() {
    return myExercise;
  }
  
  public float getCGPA() {
    return CGPA;
  }
  

  @Override
  public void dailyActivity() {
    System.out.println ("Going to college : " + collegeName);
    System.out.println ("CGPA : " + CGPA);
    myExercise.doExercise();
  }



  
}

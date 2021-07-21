package com.workshop.literal;

public class HighSchoolStudent implements Student {
  
  private Exercise myExercise;
  private String highSchoolName;
  private String programName;
  
  // Setter method for DI
  public void setHighSchoolName(String highSchoolName) {
    this.highSchoolName = highSchoolName;
  }

  // Setter method for DI
  public void setProgramName(String programName) {
    this.programName = programName;
  }

  // Setter method for DI
  public void setMyExercise(Exercise myExercise) {
    this.myExercise = myExercise;
  }
  
  public Exercise getMyExercise() {
    return myExercise;
  }

  public String getHighSchoolName() {
    return highSchoolName;
  }

  public String getProgramName() {
    return programName;
  }
  
  @Override
  public void dailyActivity() {
    System.out.println ("Going to high school : " + highSchoolName);
    System.out.println ("Studying in program : " + programName);    
    myExercise.doExercise();
  }


}

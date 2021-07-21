package com.workshop.literal;

public class HighSchoolStudent implements Student {
  
  private Exercise myExercise;
  private String highSchoolName;
  private int age;
  
  // Setter method for DI
  public void setHighSchoolName(String highSchoolName) {
    this.highSchoolName = highSchoolName;
  }

  // Setter method for DI
  public void setAge(int age) {
		this.age = age;
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

  public int getAge() {
		return age;
  }
  
  @Override
  public void dailyActivity() {
    System.out.println ("Going to high school : " + highSchoolName);
    System.out.println ("Age : " + age);    
    myExercise.doExercise();
  }


}

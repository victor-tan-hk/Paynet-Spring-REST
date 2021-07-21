package com.workshop.javaconfig;

import org.springframework.beans.factory.annotation.Value;

public class HighSchoolStudent implements Student {
  
  private Exercise myExercise;
  
  @Value("${myHighSchool}")
  private String highSchoolName;

  @Value("${myAge}")
  private int age;
  
  public HighSchoolStudent(Exercise myExercise) {
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
    System.out.println ("My age is : " + age);    
    myExercise.doExercise();
  }


}

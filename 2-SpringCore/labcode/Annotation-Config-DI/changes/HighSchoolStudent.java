package com.workshop.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HighSchoolStudent implements Student {
  
  @Autowired
  private Exercise myExercise;
  
  @Value("${myHighSchool}")
  private String highSchoolName;

  @Value("${myAge}")
  private int age;
  
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

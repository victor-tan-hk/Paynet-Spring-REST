package com.workshop.javaconfig;

import java.util.List;
import java.util.Map;

public class CollegeStudent implements Student {

  private Exercise myExercise;
  
  private List<String> favouritePlaces;
  private Map<String, Integer> subjectMarks;  
  
  public CollegeStudent(Exercise myExercise) {
    this.myExercise = myExercise;
  }
  
  public void setFavouritePlaces(List<String> favouritePlaces) {
    this.favouritePlaces = favouritePlaces;
  }

  public void setSubjectMarks(Map<String, Integer> subjectMarks) {
    this.subjectMarks = subjectMarks;
  }

  public List<String> getFavouritePlaces() {
    return favouritePlaces;
  }

  public Map<String, Integer> getSubjectMarks() {
    return subjectMarks;
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

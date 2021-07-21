package com.workshop.useinterface;


public class Student {
  
  Exercise myFavouriteExercise;
  
  public Student() {
    myFavouriteExercise = new SwimmingExercise();
  }
  
  public void doSomeExercises() {
    // 100 lines of code which uses this statement below
    myFavouriteExercise.doExercise();
  }
  
  public static void main(String[] args) {
    
    Student myStudent = new Student();
    myStudent.doSomeExercises();

  }

}



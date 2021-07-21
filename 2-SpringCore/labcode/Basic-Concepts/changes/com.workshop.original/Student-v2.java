package com.workshop.original;


public class Student {
  
  SwimmingExercise myFavouriteExercise;
  
  public Student() {
    myFavouriteExercise = new SwimmingExercise();
  }
  
  public void doSomeExercises() {
    // 100 lines of code which uses this statement below
    myFavouriteExercise.newSwimmingMethod();
  }
  
  public static void main(String[] args) {
    Student myStudent = new Student();
    myStudent.doSomeExercises();

  }

}



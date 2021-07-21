package com.workshop.original;


public class Student {
  
  JoggingExercise myFavouriteExercise;
  
  public Student() {
    myFavouriteExercise = new JoggingExercise();
  }
  
  public void doSomeExercises() {
    // 100 lines of code which uses this statement below
    myFavouriteExercise.doJogging();
  }
  
  public static void main(String[] args) {
    Student myStudent = new Student();
    myStudent.doSomeExercises();

  }

}



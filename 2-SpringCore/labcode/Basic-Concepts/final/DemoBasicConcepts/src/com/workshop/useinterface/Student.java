package com.workshop.useinterface;

public class Student {
  
  Exercise myFavouriteExercise;
  
  public Student(Exercise myFavouriteExercise) {
    this.myFavouriteExercise = myFavouriteExercise;
  }
  
  public void doSomeExercises() {
    // 100 lines of code which uses this statement below
    myFavouriteExercise.doExercise();
  }
  
  public static void main(String[] args) {
    
    Exercise firstFavouriteExercise = new JoggingExercise();
    Exercise secondFavouriteExercise = new SwimmingExercise();
    
    Student firstStudent = new Student(firstFavouriteExercise);
    Student secondStudent = new Student(secondFavouriteExercise);
    
    firstStudent.doSomeExercises();
    secondStudent.doSomeExercises();

  }

}



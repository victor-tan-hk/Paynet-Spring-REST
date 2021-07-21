package com.workshop.servlets;

import java.io.Serializable;

public class Student implements Serializable {
  
  private String firstName;
  private String lastName;
  private int age;

  public Student() {
  }
  
  
  public Student(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }


  public String getFirstName(){
     return firstName;
  }
  public String getLastName(){
     return lastName;
  }
  public int getAge(){
     return age;
  }
  public void setFirstName(String firstName){
     this.firstName = firstName;
  }
  public void setLastName(String lastName){
     this.lastName = lastName;
  }
  public void setAge(Integer age){
     this.age = age;
  }
}
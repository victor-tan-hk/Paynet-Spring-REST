package com.workshop.rest;


public class Employee {
  
  private String name;
  private int age;
  private boolean isMarried;
  private Resume resume;
  
  public Employee(String name, int age, boolean isMarried, Resume resume) {
    super();
    this.name = name;
    this.age = age;
    this.isMarried = isMarried;
    this.resume = resume;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public boolean isMarried() {
    return isMarried;
  }
  public void setMarried(boolean isMarried) {
    this.isMarried = isMarried;
  }
  public Resume getResume() {
    return resume;
  }
  public void setResume(Resume resume) {
    this.resume = resume;
  }
  
  @Override
  public String toString() {
    return "Employee [name=" + name + ", age=" + age + ", isMarried=" + isMarried + ", resume=" + resume + "]";
  }
  
  

}

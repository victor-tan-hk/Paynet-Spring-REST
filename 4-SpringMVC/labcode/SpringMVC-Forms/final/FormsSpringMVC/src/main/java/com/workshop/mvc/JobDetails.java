package com.workshop.mvc;

public class JobDetails {
  
  private String jobRole;
  private int salary;
  private boolean isPermanent;
  
  
  public JobDetails() {
    
  }
  
  public JobDetails(String jobRole, int salary, boolean isPermanent) {
    this.jobRole = jobRole;
    this.salary = salary;
    this.isPermanent = isPermanent;
  }
  
  public String getJobRole() {
    return jobRole;
  }
  public void setJobRole(String jobRole) {
    this.jobRole = jobRole;
  }
  public int getSalary() {
    return salary;
  }
  public void setSalary(int salary) {
    this.salary = salary;
  }
  
  public boolean getIsPermanent() {
    return isPermanent;
  }
  public void setIsPermanent(boolean isPermanent) {
    this.isPermanent = isPermanent;
  }
  

}

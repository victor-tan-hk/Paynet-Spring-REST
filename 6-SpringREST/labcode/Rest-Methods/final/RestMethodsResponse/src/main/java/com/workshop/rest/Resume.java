package com.workshop.rest;

import java.util.Arrays;


public class Resume {

  private String university;
	private float CGPA;
  private String[] spokenLanguages;
  private String skillSets;
  private int yearsExperience;
  
  public Resume(String university, float cGPA, String[] spokenLanguages, String skillSets, int yearsExperience) {
    super();
    this.university = university;
    CGPA = cGPA;
    this.spokenLanguages = spokenLanguages;
    this.skillSets = skillSets;
    this.yearsExperience = yearsExperience;
  }

  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

  public float getCGPA() {
    return CGPA;
  }

  public void setCGPA(float cGPA) {
    CGPA = cGPA;
  }

  public String[] getSpokenLanguages() {
    return spokenLanguages;
  }

  public void setSpokenLanguages(String[] spokenLanguages) {
    this.spokenLanguages = spokenLanguages;
  }

  public String getSkillSets() {
    return skillSets;
  }

  public void setSkillSets(String skillSets) {
    this.skillSets = skillSets;
  }

  public int getYearsExperience() {
    return yearsExperience;
  }

  public void setYearsExperience(int yearsExperience) {
    this.yearsExperience = yearsExperience;
  }

  @Override
  public String toString() {
    return "Resume [university=" + university + ", CGPA=" + CGPA + ", spokenLanguages="
        + Arrays.toString(spokenLanguages) + ", skillSets=" + skillSets + ", yearsExperience=" + yearsExperience + "]";
  }
  
  
  
  
}

package com.workshop.rest;

import java.util.Arrays;

public class DishPair {
  
  private String text;
  private String[] pairings;
  
  public DishPair(String text, String[] pairings) {
    super();
    this.text = text;
    this.pairings = pairings;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String[] getPairings() {
    return pairings;
  }

  public void setPairings(String[] pairings) {
    this.pairings = pairings;
  }

  @Override
  public String toString() {
    return "DishPair [text=" + text + ", pairings=" + Arrays.toString(pairings) + "]";
  }
  
  
  

}

package com.workshop.user;

import com.workshop.operations.StringOperations;

public class UserProgram {


  public static void main(String[] args) {

    StringOperations operations = new StringOperations();

    System.out.println(operations.simpleStringOperation("cat"));
    System.out.println(operations.intermediateStringOperation("dog"));
    System.out.println(operations.complexStringOperation("mouse"));
  }

}

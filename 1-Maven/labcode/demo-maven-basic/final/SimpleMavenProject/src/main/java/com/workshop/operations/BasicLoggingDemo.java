package com.workshop.operations;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class BasicLoggingDemo {
  /* Get actual class name to be printed on */
  static Logger log = Logger.getLogger(BasicLoggingDemo.class.getName());

  public static void main(String[] args)throws IOException,SQLException{
    System.out.println ("From BasicLoggingDemo");
    log.debug("Hello this is a debug message");
    log.info("Hello this is an info message");
  }
}

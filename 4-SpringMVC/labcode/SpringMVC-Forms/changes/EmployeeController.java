package com.workshop.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {
  
  
  @RequestMapping("/showForm")
  public String showForm() {
    return "employee-form";
  }

  @RequestMapping("/processForm")
  public String processForm() {
    return "employee-details";
  }

}

package com.workshop.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
  
  @RequestMapping("/processForm-v2")
  public String processFormv2(
      @RequestParam("employeeName") String theName,
      @RequestParam("employeeRole") String theRole, Model model) {
    
    String niceThingToSay = theName + ", you are an awesome " + theRole + " !!! ";
    
    JobDetails jd = new JobDetails(theRole, 5000, false);
    
    model.addAttribute("message",niceThingToSay);
    model.addAttribute("jobInfo", jd);
    
    return "employee-details";
  }  

}

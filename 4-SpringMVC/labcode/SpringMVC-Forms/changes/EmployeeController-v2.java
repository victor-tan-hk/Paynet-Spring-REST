package com.workshop.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
  
  @RequestMapping("/processForm-v2")
  public String processFormv2(HttpServletRequest request, Model model) {
    
    String employeeName = request.getParameter("employeeName");
    String employeeRole = request.getParameter("employeeRole");
    String niceThingToSay = employeeName + ", you are an awesome " + employeeRole + " !!! ";
    
    JobDetails jd = new JobDetails(employeeRole, 5000, false);
    
    model.addAttribute("message",niceThingToSay);
    model.addAttribute("jobInfo", jd);
    
    return "employee-details";
  }  

}

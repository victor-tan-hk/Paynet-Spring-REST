package com.workshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet("/processForm")
public class FirstFormServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private static final Logger LOGGER = 
      LogManager.getLogger(FirstFormServlet.class.getName());
  
  public FirstFormServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    LOGGER.debug("Debug Message Logged !!!");
    LOGGER.info("Info Message Logged !!!");
    LOGGER.trace("Trace Message Logged !!!");
    LOGGER.warn("Warn Message Logged !!!!");
    LOGGER.error("Error Message Logged !!!");
    
    String personName = request.getParameter("name");
    String languageChoice = request.getParameter("language");
    
    String message = "";
    if (languageChoice.equals("java")) 
      message = this.getServletContext().getInitParameter("goodMessage");
    else
      message = this.getServletContext().getInitParameter("badMessage");
    
    System.out.println (message);
    
    request.setAttribute("displayMessage", message);
    
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("basic-first-form.jsp");

    requestDispatcher.forward(request, response);    

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println ("inside doPost of FirstFormServlet");
    doGet(request, response);
  }

}

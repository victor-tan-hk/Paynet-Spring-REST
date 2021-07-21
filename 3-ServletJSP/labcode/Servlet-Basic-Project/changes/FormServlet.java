package com.workshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public FormServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println ("inside doGet of FormServlet");
    
    String personName = request.getParameter("name");
    String languageChoice = request.getParameter("language");
    
    String message = "";
    if (languageChoice.equals("java")) 
      message = getInitParameter("goodMessage");
    else
      message = getInitParameter("badMessage");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      // Write some content
      out.println("<html>");
      out.println("<body>");
      out.println("<h1>Hello : " + personName + "</h1>");
      out.println("<hr>");
      out.println("<h2>Your favourite language : " + languageChoice + "</h2>");
      out.println("<h2> " + message + "</h2>");
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }	
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println ("inside doPost of FormServlet");
    doGet(request, response);
  }

}

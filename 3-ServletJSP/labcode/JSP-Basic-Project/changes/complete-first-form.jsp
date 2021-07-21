<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>

<h1> Hello : <%= request.getParameter("name") %> </h1>
<hr>
<h2> Your favourite language : <%= request.getParameter("language") %> </h2>

<%
  String languageChoice = request.getParameter("language");
  String message = "";
    if (languageChoice.equals("java")) 
      message = application.getInitParameter("goodMessage");
    else
      message = application.getInitParameter("badMessage");
  
  out.println("<h2>" + message + "</h2>");
%> 


</body>
</html>

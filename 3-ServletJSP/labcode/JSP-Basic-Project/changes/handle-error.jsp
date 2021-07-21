<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<body>

<h1>An unexpected error occurred ! </h1>
<h2>The exact exception was : <%= exception %></h2>
<br>
This problem occurred in the following place:<br/>
<pre>
<% exception.printStackTrace( new PrintWriter( out ) ); %>
</pre>    

</body>
</html>
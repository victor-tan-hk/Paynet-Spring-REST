<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page info="Demonstrating page directives" %>
<%@ page import="com.workshop.servlets.Student"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>

<body>

	<table>

		<%
		  StringBuffer sb = new StringBuffer();

		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("Peter", "Parker", 22));
		studentList.add(new Student("Clark", "Kent", 30));
		studentList.add(new Student("Mary", "Jane", 25));

		for (Student student : studentList) {
		  sb.append("<tr>");
		  sb.append("<td>" + student.getFirstName() + "</td>");
		  sb.append("<td>" + student.getAge() + "</td>");
		  sb.append("</tr>");

		}

		out.println(sb);
		%>

	</table>

</body>
</html>

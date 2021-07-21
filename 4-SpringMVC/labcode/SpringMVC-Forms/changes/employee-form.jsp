<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>

    <form action="processForm">

        Name: <input type="text" name="employeeName" /> 
        <br /><br />
         
        <label for="role">Employee job role :</label> 
        <select id="role" name="employeeRole">
            <option value="Developer">Developer</option>
            <option value="Tester">Tester</option>
            <option value="Project Manager">Project Manager</option>
        </select> 
        <br /><br /> 
        
        <input type="submit" value="Submit" />

    </form>


</body>
</html>
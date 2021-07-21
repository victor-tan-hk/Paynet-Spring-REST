<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
    <form action="processFirstForm">

        Name: <input type="text" name="name" /> 
        <br /><br />
         
        <label for="language">What is your favourite
            programming language :</label> 
        <select id="language" name="language">
            <option value="java">Java</option>
            <option value="python">Python</option>
            <option value="cplusplus">C++</option>
        </select> 
        <br /><br /> 
        
        <input type="submit" value="Submit" />

    </form>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<h1>Enter Your Details</h1>
<form method="post" action="hello-servlet">
    <span>Intern Name</span> <input name="name" type="text" placeholder="Enter your name"> <br>
    <span>Intern ID</span> <input name="internId" type="text" placeholder="Enter your Id"> <br>
    <span>Intern Team Id</span> <input name="teamId" type="text" placeholder="Enter your Team Id"><br>
    <input type="submit" value="Submit your details">
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>
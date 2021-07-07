<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
</head>
<body>
	
	<h3>Employee Login</h3><br>
	<hr><br>
	<form action="login" method="post">
		User name:<br> <input type="text" name="uname"><br><br>
		Password:<br> <input type="password" name="password"><br><br>
		<input type="submit">
	</form>
	<br><br>
	New User? Click <a href="http://localhost:8080/Bank_server_1/registrationEmplyee.jsp">here</a> to register.


</body>
</html>
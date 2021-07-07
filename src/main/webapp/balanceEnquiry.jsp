<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		if(session.getAttribute("userName")==null)
		{
			response.sendRedirect("employeeLogin.jsp");
		}
	
	%>
	
	<h3>Check Balance</h3><hr><br><br><br>
	<form action="BalanceEnquiryController" method="post">
		Customer First Name: <br><br><input type="text" name="fname"><br><br>
		Customer Last Name: <br><br><input type="text" name="lname"><br><br>
		Account Number: <br><br><input type="text" name="acno"><br><br>
		Employee Password: <br><br><input type="password" name="pass"><br><br>
		<input type="submit">
	</form>
</body>
</html>
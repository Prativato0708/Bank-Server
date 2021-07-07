<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make a Transaction</title>
</head>
<body>
	<%
		if(session.getAttribute("userName")==null)
		{
			response.sendRedirect("employeeLogin.jsp");
		}
	
	%>
	<h3>Transaction Section</h3><hr><br><br>
	<form action="depositAmount.jsp" method="post">
		Deposit Amount: <br><br><input type="submit" name="deposit" value="Deposit"><br><br>
	</form>
	<form action="withdrawAmount.jsp" method="post">
		Withdraw Amount: <br><br><input type="submit" name="deposit" value="Withdraw">
	</form>
</body>
</html>
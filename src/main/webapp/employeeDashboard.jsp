<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emplyee's Dashboard</title>
</head>
<body>
	
	<%
		response.setHeader("Cache-control", "no-cache,no-store,must-revalidate");
	
		if(session.getAttribute("userName")==null)
		{
			response.sendRedirect("employeeLogin.jsp");
		}
	
	%>
	
	<h3>Welcome to Dashboard</h3><hr><br><br>
	
	<form action="customerRegistration.jsp" method="post">
		New Customer Form: <input type="submit" value="Click here"><br><br>
	</form>
	<form action="transactionPage.jsp" method="post">
		Make a Transaction: <input type="submit" value="click Here"><br><br>
	</form>
	<form action="balanceEnquiry.jsp" method="post">
		Balance Enquiry: <input type="submit" value="Click Here"><br><br>
	</form>
	
	
	<form action="logout" method="post">
		<input type="submit" value="Log out">
	</form>
	
</body>
</html>
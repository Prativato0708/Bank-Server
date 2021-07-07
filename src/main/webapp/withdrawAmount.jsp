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
	
	Amount Withdraw Page<hr><br><br>
	<form action="WithdrawController" method="post" >
		Customer Name:<br><br> <input type="text" name="customerName"><br><br>
		Account Number:<br><br><input type="text" name="accNo"><br><br>
		Enter Amount:<br><br> <input type="text" name="depositeAmount"><br><br>
		Re-enter Amount:<br><br> <input type="text" name="reenterdepositeAmount"><br><br>
		Employee Password:<br><br><input type="password" name="pass"><br><br>
		<input type="submit" value="Proceed">
	</form>

</body>
</html>
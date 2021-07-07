<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New CUstomer Registration</title>
</head>
<body>
	<%
		if(session.getAttribute("userName")==null)
		{
			response.sendRedirect("employeeLogin.jsp");
		}
	
	%>
	
	<h3>New Customer Registration Form</h3><hr><br><br><br>
	<form action="customerRegistration" method="post">
		First Name:<input type="text" name="Fname" placeholder="First Name"><br><br>
		Last Name:<input type="text" name="Lname" placeholder="Last Name"><br><br>
		Age:<input type="text" name="Age"><br><br>
		Sex: Male<input type="radio" id="male" name="Gender" value="male">
		Female<input type="radio" id="female" name="Gender" value="female"><br><br>
		Aadhar Number: <input type="text" name="Aadhar" placeholder="xxxx-xxxx-xxxx"><br><br>
		Pan Number:<input type="text" name="Pan" placeholder="xxxxxxxx"><br><br>
		Address: <input type="text" name="Address"><br><br>
		Mobile Number: <input type="text" name="Mobile" placeholder="10 Digit Mobile Number"><br><br>
		Email Address: <input type="text" name="Email" placeholder="abc@xyz.com"><br><br>
		Facilities: ATM <input type="checkbox" id="atm" name="facilities" value="atm">
					Check Book <input type="checkbox" id="checkbook" name="facilities" value="checkbook">
					Net banking <input type="checkbox" id="netbanking" name="facilities" value="netbanking">
					Mobile Banking <input type="checkbox" id="mobilebanking" name="facilities" value="mobilebanking"><br><br>
		Amount Deposited: <input type="text" name="Amount"><br><br>
		<input type="submit">
	</form>

</body>
</html>
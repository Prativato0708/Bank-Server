<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Employee Registration</title>
</head>
<body>
	<h3>New Employee Registration Form</h3><br>
	<hr><br>
	
	<form action="employeeRegistration" method="post">
	
		First Name:<input type="text" name="Fname" placeholder="First Name"><br><br>
		Last Name:<input type="text" name="Lname" placeholder="Last Name"><br><br>
		Age:<input type="text" name="Age"><br><br>
		Sex: Male<input type="radio" id="male" name="Gender" value="male">
		Female<input type="radio" id="female" name="Gender" value="female"><br><br>
		Aadhar Number: <input type="text" name="Aadhar"><br><br>
		Pan Number:<input type="text" name="Pan"><br><br>
		Address: <input type="text" name="Address"><br><br>
		Mobile Number: <input type="text" name="Mobile"><br><br>
		Email Address: <input type="text" name="Email"><br><br>
		Username: <input type="text" name="Username"><br><br>
		New Password: <input type="password" name="NewPass"><br><br>
		Confirm new password: <input type="password" name="ConfirmPass"><br><br>
		<input type="submit">
	
	</form>
	
	
</body>
</html>
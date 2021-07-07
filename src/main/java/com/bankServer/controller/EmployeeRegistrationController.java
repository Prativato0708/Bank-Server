package com.bankServer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankServer.dao.RegistrationEmployeeDao;
import com.bankServer.model.EmployeeRegistrationModel;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/employeeRegistration")
public class EmployeeRegistrationController extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fname=request.getParameter("Fname");
		String lname=request.getParameter("Lname");
		String email=request.getParameter("Email");
		String mobile=request.getParameter("Mobile");
		String address=request.getParameter("Address");
		String aadhar=request.getParameter("Aadhar");
		String pan=request.getParameter("Pan");
		String sex=request.getParameter("Gender");
		int age=Integer.parseInt(request.getParameter("Age"));
		String uname=request.getParameter("Username");
		String pass=request.getParameter("NewPass");
		String newPass=request.getParameter("ConfirmPass");
		
		int result=0;
		
		EmployeeRegistrationModel model=new EmployeeRegistrationModel();
		if(pass.equals(newPass))
		{
			model.setFname(fname);
			model.setLname(lname);
			model.setEmail(email);
			model.setMobile(mobile);
			model.setAddress(address);
			model.setAadhar(aadhar);
			model.setPan(pan);
			model.setSex(sex);
			model.setAge(age);
			model.setUname(uname);
			model.setPass(newPass);
			
			RegistrationEmployeeDao reg=new RegistrationEmployeeDao();
			try {
				result=reg.registerEmployee(model);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		PrintWriter out=response.getWriter();
		
		if(result==1)
			out.println("<h1>Registration Successful.<h1>");
		else
			out.println("<h1>Invalid Request</h1>");
		
		
		out.println("Click <a href=\"http://localhost:8080/Bank_server_1/employeeLogin.jsp\">here</a> to login.");
		
	}
}

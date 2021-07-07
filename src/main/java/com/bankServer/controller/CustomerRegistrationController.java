package com.bankServer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankServer.dao.CustomerRegistrationDao;
import com.bankServer.model.CustomerRegistrationModel;

/**
 * Servlet implementation class CustomerRegistrationController
 */
@WebServlet("/customerRegistration")
public class CustomerRegistrationController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fname=request.getParameter("Fname");
		String lname=request.getParameter("Lname");
		int age=Integer.parseInt(request.getParameter("Age"));
		String sex=request.getParameter("Gender");
		String aadhar=request.getParameter("Aadhar");
		String pan=request.getParameter("Pan");
		String address=request.getParameter("Address");
		String mobno=request.getParameter("Mobile");
		String email=request.getParameter("Email");
		String facilities[]=request.getParameterValues("facilities");
		String amount=request.getParameter("Amount");
		int count=0;
		int result=0;
		
		
		String accountNo="100500";
		int max=99999;
        int min=10000;
        accountNo=accountNo+(int)(Math.random()*(max-min+1)+min);
		
		CustomerRegistrationModel model=new CustomerRegistrationModel();
		model.setFname(fname);
		model.setLname(lname);
		model.setAge(age);
		model.setSex(sex);
		model.setAadhar(aadhar);
		model.setPan(pan);
		model.setAddress(address);
		model.setMobno(mobno);
		model.setEmail(email);
		
		for(String s: facilities)
		{
			if(s.equals("atm"))
			{
				count++;
				model.setAtmCard("Yes");
			}
		}
		if(count==0)
		{
			model.setAtmCard("No");
		}
		count=0;
		
		
		
		for(String s: facilities)
		{
			if(s.equals("checkbook"))
			{
				count++;
				model.setCheckBook("Yes");
			}
		}
		if(count==0)
		{
			model.setCheckBook("No");
		}
		count=0;
		
		
		for(String s: facilities)
		{
			if(s.equals("netbanking"))
			{
				count++;
				model.setNetBanking("Yes");
			}
		}
		if(count==0)
		{
			model.setNetBanking("No");
		}
		count=0;
		
		
		for(String s: facilities)
		{
			if(s.equals("mobilebanking"))
			{
				count++;
				model.setMobileBanking("Yes");
			}
		}
		if(count==0)
		{
			model.setMobileBanking("No");
		}
		count=0;
		
		
		model.setAmount(amount);
		model.setAccountNo(accountNo);
		
		CustomerRegistrationDao dao=new CustomerRegistrationDao();
		try {
			result=dao.registerCustomer(model);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out=response.getWriter();
		
		if(result==1)
		{
			
			out.println("<h1>Registration Successfull.<h1>");
			out.println("<br><br><h1>Account Number: "+ accountNo + "</h1>");
			out.println("<br><br><h3>Balance: "+ amount);
		}
		else
		{
			out.println("Invalid Request");
		}
	}

}

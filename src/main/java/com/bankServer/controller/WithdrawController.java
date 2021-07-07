package com.bankServer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankServer.dao.DepositeAmountDao;
import com.bankServer.dao.WithdrawAmountDao;
import com.bankServer.model.DepositeModel;
import com.bankServer.model.WithdrawModel;

/**
 * Servlet implementation class WithdrawController
 */
@WebServlet("/WithdrawController")
public class WithdrawController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String customerName=request.getParameter("customerName");
		String accNo=request.getParameter("accNo");
		String withdrawAmount=request.getParameter("depositeAmount");
		String reenterWithdrawAmount=request.getParameter("reenterdepositeAmount");
		String pass=request.getParameter("pass");
		
		String result="";
		String[] name=customerName.split(" ");
		
		PrintWriter out=response.getWriter();
		
		WithdrawModel model=new WithdrawModel();
		WithdrawAmountDao dao=new WithdrawAmountDao();
		
		
		if(withdrawAmount.equals(reenterWithdrawAmount))
		{
			model.setFname(name[0]);
			model.setLname(name[1]);
			model.setAcno(accNo);
			model.setAmount(reenterWithdrawAmount);
		}
		else
		{
			result="Wrong Amount Entered.";
		}
		
		HttpSession session=request.getSession();
		if(session.getAttribute("password").equals(pass))
		{
			
			try {
				result=dao.deposite(model);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			result="Invalid Password";
		}
	
		out.println(result);
	}

}

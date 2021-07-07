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

import com.bankServer.dao.BalanceEnquiryDao;
import com.bankServer.model.BalanceEnquiryModel;

/**
 * Servlet implementation class BalanceEnquiryController
 */
@WebServlet("/BalanceEnquiryController")
public class BalanceEnquiryController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String acno=request.getParameter("acno");
		String pass=request.getParameter("pass");
		String result="output asche na";
		
		BalanceEnquiryModel model=new BalanceEnquiryModel();
		BalanceEnquiryDao dao=new BalanceEnquiryDao();
		
		HttpSession session=request.getSession();
		if(pass.equals(session.getAttribute("password")))
		{
			model.setFname(fname);
			model.setLname(lname);
			model.setAccountno(acno);
			
			try {
				result=dao.chcekBalance(model);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			result="Invalid Password";
		}
		PrintWriter out=response.getWriter();
		out.println(result);
	}

}

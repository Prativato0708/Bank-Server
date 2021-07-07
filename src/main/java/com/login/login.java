package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankServer.dao.*;


/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("password");
		
		LoginDao dao=new LoginDao();
		
		if(dao.checkLogin(uname, pass))
		{
			HttpSession session=request.getSession();
			session.setAttribute("userName",uname);
			session.setAttribute("password", pass);
			
			response.sendRedirect("employeeDashboard.jsp");
		}
		else
		{
			response.sendRedirect("employeeLogin.jsp");
		}
	}

}

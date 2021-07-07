package com.bankServer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bankServer.model.BalanceEnquiryModel;

public class BalanceEnquiryDao 
{
	String url="jdbc:mysql://localhost:3306/bank_server";
	String username="root";
	String password="Abcde@12345";
	
	
	public String chcekBalance(BalanceEnquiryModel model) throws ClassNotFoundException, SQLException
	{
		String query="select fname,lname,balance from customer where accountno=?";
		Class.forName("com.mysql.jdbc.Driver");
		String amount="";
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, model.getAccountno());
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			if((model.getFname().equals(rs.getString("fname")))&&(model.getLname().equals(rs.getString("lname"))))
				amount=rs.getString("balance");
		}
		st.close();
		con.close();
		return amount;
	}
}

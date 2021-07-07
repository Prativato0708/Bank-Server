package com.bankServer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bankServer.model.DepositeModel;

public class DepositeAmountDao 
{
	static String url="jdbc:mysql://localhost:3306/bank_server";
	static String username="root";
	static String password="Abcde@12345";
	public String deposite(DepositeModel model) throws ClassNotFoundException, SQLException
	{
		String query="select * from customer where accountno=?";
		Class.forName("com.mysql.jdbc.Driver");
		String amount="";
		int deposite=Integer.parseInt(model.getAmount());
		int result=0;
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, model.getAcno());
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			if((model.getFname().equals(rs.getString("fname")))&&(model.getLname().equals(rs.getString("lname"))))
				amount=rs.getString("balance");
		}
		st.close();
		con.close();
		result=updateBalance(Integer.parseInt(amount),deposite,model.getAcno());
		if(result==1)
		{
			return ("Transaction Successful");
		}
		else
		{
			return ("Transaction Failed.");
		}
	}
	
	
	public static int updateBalance(int balance, int deposite,String acno) throws ClassNotFoundException, SQLException
	{
		String query="update customer set balance=? where accountno=?";
		Class.forName("com.mysql.jdbc.Driver");
		balance=balance+deposite;
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, balance+"");
		st.setString(2, acno);
		int result=st.executeUpdate();
		return (result);
	}
}

package com.bankServer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bankServer.model.CustomerRegistrationModel;


public class CustomerRegistrationDao 
{
	String url="jdbc:mysql://localhost:3306/bank_server";
	String username="root";
	String password="Abcde@12345";
	public int registerCustomer(CustomerRegistrationModel model) throws ClassNotFoundException, SQLException
	{
		String query="insert into customer values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, model.getFname());
		st.setString(2, model.getLname());
		st.setInt(3, model.getAge());
		st.setString(4, model.getSex());
		st.setString(5, model.getAadhar());
		st.setString(6, model.getPan());
		st.setString(7, model.getAddress());
		st.setString(8, model.getMobno());
		st.setString(9, model.getEmail());
		st.setString(10, model.getAtmCard());
		st.setString(11, model.getCheckBook());
		st.setString(12, model.getNetBanking());
		st.setString(13, model.getMobileBanking());
		st.setString(14, model.getAmount());
		st.setString(15, model.getAccountNo());
		result=st.executeUpdate();
		
		st.close();
		con.close();
		
		
		return result;
	}
}

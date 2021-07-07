package com.bankServer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bankServer.model.EmployeeRegistrationModel;

public class RegistrationEmployeeDao 
{
	String url="jdbc:mysql://localhost:3306/bank_server";
	String username="root";
	String password="Abcde@12345";
	public int registerEmployee(EmployeeRegistrationModel model) throws ClassNotFoundException, SQLException
	{
		String query="insert into employee values(?,?,?,?,?,?,?,?,?,?,?)";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, model.getFname());
		st.setString(2, model.getLname());
		st.setString(3, model.getEmail());
		st.setString(4, model.getMobile());
		st.setString(5, model.getAddress());
		st.setString(6, model.getAadhar());
		st.setString(7, model.getPan());
		st.setString(8, model.getSex());
		st.setInt(9, model.getAge());
		st.setString(10, model.getUname());
		st.setString(11, model.getPass());
		result=st.executeUpdate();
		st.close();
		con.close();
		
		return result;
	}
	
}

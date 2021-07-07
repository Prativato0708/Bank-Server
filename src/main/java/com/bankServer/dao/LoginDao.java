package com.bankServer.dao;

import java.sql.*;


public class LoginDao 
{
	String sql="select * from employee where username=? and password=?";
	String url="jdbc:mysql://localhost:3306/bank_server";
	String userName="root";
	String password="Abcde@12345";
	public boolean checkLogin(String uname,String pass)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userName,password);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs=st.executeQuery();
			if(rs.next())
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
}

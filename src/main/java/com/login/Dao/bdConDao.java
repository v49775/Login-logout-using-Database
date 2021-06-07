package com.login.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class bdConDao {
	String url="jdbc:mysql://localhost:3306/logindb";
	String user="root";
	String pass="v49775";
	String sql="select * from login where username=? and password=?";
	public boolean checkCon(String uname,String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,uname);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return false;
	}

}

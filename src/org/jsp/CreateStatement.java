package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatement {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Y1012Jqkhkp");
			System.out.println("connection Establish");
			st=con.createStatement();
			System.out.println("plateform created");
		}
		
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
					System.out.println("connection closed");
					
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
			
			if(st!=null)
			{
				try {
					st.close();
					System.out.println("statement closed");
					
				}
				catch(SQLException e){
					e.printStackTrace();
				}
		}
		}
	}
}

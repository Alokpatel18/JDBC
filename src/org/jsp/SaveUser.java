package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveUser {
	public static void main(String[] args) {
		 Connection con =null;
		 Statement st=null;
		 String qry="insert into user values(3,'pushpa',98645376828)";
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_java","root","Y1012Jqkhkp");
		
			st=con.createStatement();
			int res=st.executeUpdate(qry);
			System.out.println(res+"row effected");
		 }
		 catch(ClassNotFoundException|SQLException e)
		 {
			 e.printStackTrace();
			 
			 	 
		 }
		 finally {
			 if(con!=null) 
			 {
				 try
				 {
					 con.close();
					 System.out.println("connection is closed");
					 
				 }
				 catch(SQLException e)
				 {
					 e.printStackTrace();
				 }
			 }
			 if(st!=null) {
				 try {
					 st.close();
					 System.out.println("statement is closed");
					 
				 }
				 catch(SQLException e)
				 {
					 e.printStackTrace();
				 }
		 }
		 }

		}

	}



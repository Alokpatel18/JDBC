package org.jsp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestEstablishConnection {

	public static void main(String[] args) {
	 Connection con =null;
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 System.out.println("Driver is loaded or Registered");
		 con= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Y1012Jqkhkp");
		 System.out.println("connection is Esablish");
	 }
	 catch(ClassNotFoundException|SQLException e)
	 {
		 e.printStackTrace();
		 
		 	 
	 }
	 finally {
		 if(con!=null) {
			 try {
				 con.close();
				 System.out.println("connection is closed");
				 
			 }
			 catch(SQLException e)
			 {
				 e.printStackTrace();
			 }
		 }
	 }

	}

}


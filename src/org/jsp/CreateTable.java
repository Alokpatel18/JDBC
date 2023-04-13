package org.jsp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
	 Connection con =null;
	 Statement st=null;
	 String query="create table user(id int not null,name varchar(45) null,phone bigint(20) null,primary key(id))";
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		
		 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_java","root","Y1012Jqkhkp");
	
		st=con.createStatement();
		boolean res=st.execute(query);
		System.out.println(res+ " is the returned value and table created");
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



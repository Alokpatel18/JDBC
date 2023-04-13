package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BatchWithStatement {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_java", "root", "Y1012Jqkhkp");
			st = con.createStatement();	
			st.addBatch("delete from user where phone=777");
			st.addBatch("update user set name='xyz',phone=777 where id=8");
			st.addBatch("insert user values(20,'kaliya',456)");
			
			int[] r=st.executeBatch();
			
			for(int i=0;i<r.length;i++)
			{
				System.out.println(r[i] + "rows are affected");
			}
		}
			
		catch(ClassNotFoundException | SQLException e)
		
	    {
		e.printStackTrace();

	}finally
	{
		if (con != null) {
			try {
				con.close();
				System.out.println("connection is closed");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
				System.out.println("statement is closed");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

}



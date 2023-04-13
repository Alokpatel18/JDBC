package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertMultipleRecordsUsingPreparedStatement {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		String qry = "insert into user values(?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_java", "root", "Y1012Jqkhkp");

			pst = con.prepareStatement(qry);
			pst.setInt(1,7);
			pst.setString(2,"A");
			pst.setLong(3,9999);
			pst.executeUpdate();
			
			
			pst.setInt(1,8);
			pst.setString(2,"B");
			pst.setLong(3,99999);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("connection is closed");

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
					System.out.println("statement is closed");

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}



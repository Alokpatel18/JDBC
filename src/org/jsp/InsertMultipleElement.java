package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultipleElement {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String qry5 = "insert into user values(6,'bahubali',999)";
		String qry1 = "insert into user values(4,'alok',777)";
		String qry2 = "insert into user values(5,'kaal',888)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_java", "root", "Y1012Jqkhkp");

			st = con.createStatement();
			st.executeUpdate(qry5);
			st.executeUpdate(qry1);
			st.executeUpdate(qry2);
			System.out.println("record inserted sucessfully");
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

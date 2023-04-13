package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRecordById {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the id to delete the user");
		int id = sc.nextInt();
		String qry = "delete from user where id=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_java", "root", "Y1012Jqkhkp");
			pst = con.prepareStatement(qry);
			pst.setInt(1, id);
			int r = pst.executeUpdate();
			System.out.println(r + "rows deleted");

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

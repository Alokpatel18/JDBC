package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateUserUsingPreparedStatement {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		String qry = "update user set name=?,phone=? where id=?";
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the exiting id");
		int id = sc.nextInt();
		System.out.println("Enter the name and Phone number update");
		String name = sc.next();
		long phone = sc.nextLong();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_java", "root", "Y1012Jqkhkp");

			pst = con.prepareStatement(qry);
			pst.setInt(3, id);
			pst.setString(1, "name");
			pst.setLong(2, phone);

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

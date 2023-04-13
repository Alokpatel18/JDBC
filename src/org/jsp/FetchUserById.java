package org.jsp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class FetchUserById {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the id to fetch");
		int id = sc.nextInt();
		String qry = "select * from user where id=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_java", "root", "Y1012Jqkhkp");

			pst = con.prepareStatement(qry);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3));
			}

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
			if (pst != null)
			{
				try {
					pst.close();
					System.out.println("statement is closed");

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
					System.out.println("Resulset is closed");

				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}


	}
}

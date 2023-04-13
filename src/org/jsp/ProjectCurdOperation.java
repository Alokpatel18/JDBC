package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProjectCurdOperation {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter");
		System.out.println("1. To save");
		System.out.println("2. To update");
		System.out.println("3.To Delete By ID");
		System.out.println("4.To Fetch Person by ID");
		System.out.println("5.TO login");
		int choice = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "Y1012Jqkhkp");
			switch (choice) {

			case 1: {
				pst = con.prepareStatement("insert into person values (?,?,?,?,?)");
				System.out.println("Enter your id,name,age,phone,password");
				int id = sc.nextInt();
				String name = sc.next();
				int age = sc.nextInt();
				long phone = sc.nextLong();
				String password = sc.next();
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setInt(3, age);
				pst.setLong(4,phone);
				pst.setString(5, password);
				pst.executeUpdate();
				System.out.println("Your details are register Sucessfully");
				break;
			}
			case 2: {
				pst = con.prepareStatement("update person set NAME =?,AGE=?,PHONE=?,PASSWORD=? where ID=?");
				System.out.println("enter the existing id");
				int id = sc.nextInt();
				System.out.println("enter name,age,phone,password");
				String name = sc.next();
				int age = sc.nextInt();
				long phone = sc.nextLong();
				String password = sc.next();
				pst.setInt(5, id);
				pst.setString(1, name);
				pst.setInt(2, age);
				pst.setLong(3, phone);
				pst.setString(4, password);
				pst.executeUpdate();

				System.out.println("succesfully update");
				break;
			}
			case 3: {
				pst = con.prepareStatement("delete from person where ID=?");
				System.out.println("enter the id to delete the row");
				int id = sc.nextInt();
				pst.setInt(1, id);
				pst.executeUpdate();
				System.out.println("Delete Successfully");
				break;

			}

			case 4: {
				pst = con.prepareStatement("select * from person where ID =? ");
				System.out.println("enter the id to fetch");
				int id = sc.nextInt();
				pst.setInt(1, id);
				rs = pst.executeQuery();

				while (rs.next()) {
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getLong(4)
							+ " " + rs.getString(5));
				}

				break;
			}

			case 5: {
				pst = con.prepareStatement("select* from person where PHONE=? and PASSWORD =?");
				System.out.println("enter your registered phone number");
				long phone = sc.nextLong();
				System.out.println("enter your password");
				String ps = sc.next();
				pst.setLong(1, phone);
				pst.setString(2, ps);
				rs = pst.executeQuery();

				if (rs.next()) {
					System.out.println("login successfully");
					System.out.println("ID " + rs.getInt(1));
					System.out.println("name " + rs.getString(2));
					System.out.println("phone " + rs.getLong(4));
					System.out.println("age " + rs.getInt(3));

				}

				else {
					System.err.println("invalid phone or password");
				}

			}

			}
		}

		catch (ClassNotFoundException | SQLException e) {
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

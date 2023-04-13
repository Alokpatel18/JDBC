package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchWithPreparedStatement {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_java", "root", "Y1012Jqkhkp");
			pst= con.prepareStatement("insert into user values (?,?,?)");
			
			pst.setInt(1, 12);
			pst.setString(2,"Rockey");
			pst.setLong(3, 777);
			pst.addBatch();
			
			pst.setInt(1, 13);
			pst.setString(2, "rolex");
			pst.setLong(3, 888);
			pst.addBatch();
			
			pst.setInt(1,14);
			pst.setString(2,"Dilli");
			pst.setLong(3, 888);
			pst.addBatch();
			
			int[]r=pst.executeBatch();
			
			for(int i=0; i<r.length; i++)
			{
				System.out.println(r[i] + "Rows are affected");
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
		}

	}


			
		
	}



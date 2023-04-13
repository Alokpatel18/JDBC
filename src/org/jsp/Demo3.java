package org.jsp;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;
public class Demo3 
{
  public static void main(String[] args) {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the Id to fetch");
    int id = s.nextInt();
    String qry = "select*from user where Id=?";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_java", "root", "Y1012Jqkhkp");
      pst = con.prepareStatement(qry);
      pst.setInt(1, id);
      rs = pst.executeQuery();
      while (rs.next()) {
        System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getLong(3));

      }
    } catch (SQLException | ClassNotFoundException e) {
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
          System.out.println("prepared statement is closed");
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      }
      if (rs != null) {
        try {
          rs.close();
          System.out.println("Resultset is closed");
        } catch (SQLException e1) {
          e1.printStackTrace();
        }

      }
    }
  }
}



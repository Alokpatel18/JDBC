package org.jsp;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class LoadAndRegisterDemo {
	public static void main (String[] args) {
		try {
			Driver d= new Driver();
			DriverManager.registerDriver(d);
			System.out.println("deiver is loaded and Register");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	

}

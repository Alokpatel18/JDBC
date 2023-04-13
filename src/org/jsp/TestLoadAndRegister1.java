package org.jsp;

public class TestLoadAndRegister1 {

	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded or Register");
		}

		catch(ClassNotFoundException e)
		{
			System.out.println("Invalid Driver Class Name");
			e.printStackTrace();
			
		}
	}

}

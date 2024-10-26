package login;
	
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import database.DBConnect;

public class user_signin extends DBConnect {

	public void insert() throws SQLException {

		String query = "insert into user(id,username,email,pass) values(?,?,?,?);";
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id");
		int id = sc.nextInt();
		System.out.println("enter user name");
		String name = sc.next();
		System.out.println("enter email");
		String email = sc.next();
		System.out.println("enter password:");
		String pass = sc.next();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setString(3, email);
		pst.setString(4, pass);
		pst.execute();
		System.out.println("User Registered successfully!!!!");
		
	}

	

}

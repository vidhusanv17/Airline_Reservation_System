package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	String url="jdbc:mysql://localhost:3306/airline";
	String name="root";
	String pass="admin";
	public Connection con;
	public DBConnect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,name,pass);
//			System.out.println("██╗░░░██╗  ░█████╗░██╗██████╗░██╗░░░░░██╗███╗░░██╗███████╗░██████╗");
//			System.out.println("██║░░░██║  ██╔══██╗██║██╔══██╗██║░░░░░██║████╗░██║██╔════╝██╔════╝");
//			System.out.println("╚██╗░██╔╝  ███████║██║██████╔╝██║░░░░░██║██╔██╗██║█████╗░░╚█████╗░");
//			System.out.println("░╚████╔╝░  ██╔══██║██║██╔══██╗██║░░░░░██║██║╚████║██╔══╝░░░╚═══██╗");
//			System.out.println("░░╚██╔╝░░  ██║░░██║██║██║░░██║███████╗██║██║░╚███║███████╗██████╔╝");
//			System.out.println("░░░╚═╝░░░  ╚═╝░░╚═╝╚═╝╚═╝░░╚═╝╚══════╝╚═╝╚═╝░░╚══╝╚══════╝╚═════╝░");
//			System.out.println("\n\n");
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}


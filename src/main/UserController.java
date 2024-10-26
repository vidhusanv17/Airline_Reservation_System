package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import database.DBConnect;

public class UserController extends DBConnect {
	Scanner sc =new Scanner(System.in);

	public void bookflight(int id) throws SQLException {
		System.out.println("Enter the date in \"YYYY:MM:DD\" format");
		String dat = sc.nextLine();
		System.out.println("Enter the number of passengers");
		int nop = sc.nextInt();
		System.out.println("Enter the flight number");
		String fno = sc.next();
		
		String query = "insert into booking(id,fno,nop,date) values(?,?,?,?) ;";
		PreparedStatement pst = con.prepareStatement(query);

		// id shld be taken from global for checking
		

		pst.setInt(1, id);
		pst.setString(2, fno);
		pst.setInt(3, nop);
		pst.setString(4, dat);
		pst.execute();

	}

	
	
	
	public void viewflight() throws SQLException {
		System.out.println("Select the cities as \nChennai\r\n" + "Delhi\r\n" + "Mumbai\r\n" + "Kolkata\r\n"
				+ "Bangalore\r\n" + "Hyderabad");
		
		System.out.println("Enter the Departure city");
		String dep = sc.nextLine();
		System.out.println("Enter the arrival city");
		String arr = sc.nextLine();
		
		System.out.println("Flights available");
		String query = "select * from flight where dept=? and arr=? ;";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, dep);
		pst.setString(2, arr);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {

			System.out.println(rs.getString(1) + "\t\t\s" + rs.getString(2) + "\t\s" + rs.getString(3) + "\t\t\s"
					+ rs.getString(4));
		}

	}
	
	
	
	public void currentbookings(int id) throws SQLException {
		System.out.println("The current bookings are");
		String query = "select * from booking where id=? ;";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		System.out.println("BookingID" + "\t\s" + "UserID" + "\t\s" + "FlightNO" + "\t\s"
				+"No of Passengers" + "\t\s"+ "Date");
		while (rs.next()) {

			System.out.println(rs.getInt(1) + "\t\t\s" + rs.getInt(2) + "\t\s" + rs.getString(3) + "\t\t\s"
					+rs.getInt(4) + "\t\t\t\s"+ rs.getString(5));
		}
	}

	

}

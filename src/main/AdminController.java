package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import database.DBConnect;

public class AdminController extends DBConnect {
	Scanner sc = new Scanner(System.in);
	
	public void viewbookings() throws SQLException {
		System.out.println("The current bookings are");
		String query = "select * from booking  ;";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		System.out.println("BookingID" + "\t\s" + "UserID" + "\t\s" + "FlightNO" + "\t\s"
				+"No of Passengers" + "\t\s"+ "Date");
		while (rs.next()) {

			System.out.println(rs.getInt(1) + "\t\t\s" + rs.getInt(2) + "\t\s" + rs.getString(3) + "\t\t\s"
					+rs.getInt(4) + "\t\t\t\s"+ rs.getString(5));
		}
	}
	
	
	
	//NEED TO CHECK 
	public void deleteuser() throws SQLException{
		System.out.println("Enter the user id to be removed:");
		int id=sc.nextInt();
		String query = "delete from user where id=?;";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.execute();
		System.out.println("Success!!!!!");
		
		
		
	}
	
	
	public void addflight() throws SQLException{
		String query = "insert into flight  values(?,?,?,?);";
		System.out.println("Enter the flight details");
		System.out.println("Flight no:");
		String fno= sc.next();
		System.out.println("Enter departure city");
		String dept=sc.next();
		System.out.println("Arrival city:");
		String arr=sc.next();
		System.out.println("Enter Time \'HH:MM:SS\':");
		String time=sc.next();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, fno);
		pst.setString(2, dept);
		pst.setString(3, arr);
		pst.setString(4, time);
		pst.execute();	
	}
	
	
	public void viewflights() throws SQLException{
		System.out.println("The flights available are");
		String query = "select * from flight  ;";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		int idcw=20;
		System.out.println(String.format("%-"+idcw+"s%-"+idcw+"s%-"+idcw+"s%-"+idcw+"s","Flight No", "ARRIVAL", "DEPARTURE" ,"DATE" ));
		while (rs.next()) {

			System.out.println( String.format("%-"+idcw+"s%-"+idcw+"s%-"+idcw+"s%-"+idcw+"s",rs.getString(1) , rs.getString(2) , rs.getString(3), rs.getString(4)));
		
		}
	}

	
	
	
	public void deleteflight() throws SQLException{
		
		System.out.println("Enter the flight number to be removed:");
		String fno=sc.next();
		String query = "delete from flight where fno=?;";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, fno);
		pst.execute();
		System.out.println("Success!!!!!");
	}
	
	
	
	
	
	public void editflight() throws SQLException{
		System.out.println("Enter the flight number to be edited");
		String fno=sc.next();
		System.out.println("enter the option \n1.departure \n2.arrival \n3.time");
		int n =sc.nextInt();
		switch(n) {
		
		case 1:
			System.out.println("Enter the departure city");
			String dept=sc.next();
			String query = "update flight set dept=? where fno=?;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, dept);
			pst.setString(2, fno);
			pst.execute();
			break;
			
		case  2:
			System.out.println("Enter the arrival city");
			String arr=sc.next();
			query = "update flight set arr=? where fno=?;";
			pst = con.prepareStatement(query);
			pst.setString(1, arr);
			pst.setString(2, fno);
			pst.execute();
			break;
			
			
		case  3:
			System.out.println("Enter the time in HH:MM:SS");
			String time=sc.next();
			query = "update flight set time=? where fno=?;";
			pst = con.prepareStatement(query);
			pst.setString(1, time);
			pst.setString(2, fno);
			pst.execute();
			break;
		}
		
		
		
	}
	
	public void viewusers() throws SQLException{
		System.out.println("The total users are");
		String query = "select * from user  ;";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		int idcw=20;
		System.out.println(String.format("%-"+idcw+"s%-"+idcw+"s%-"+idcw+"s%-"+idcw+"s","UserID" , "UserName" , "Email","Password"));
		while (rs.next()) {

			System.out.println(String.format("%-"+idcw+"s%-"+idcw+"s%-"+idcw+"s%-"+idcw+"s",rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4)));
		}
	}

	
	
	

	
	
}




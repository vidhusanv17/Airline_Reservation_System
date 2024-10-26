package home;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import database.DBConnect;
import login.user_signin;
import main.AdminController;
import main.UserController;

public class Home extends DBConnect {

	public void CC() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("██╗░░░██╗  ░█████╗░██╗██████╗░██╗░░░░░██╗███╗░░██╗███████╗░██████╗");
		System.out.println("██║░░░██║  ██╔══██╗██║██╔══██╗██║░░░░░██║████╗░██║██╔════╝██╔════╝");
		System.out.println("╚██╗░██╔╝  ███████║██║██████╔╝██║░░░░░██║██╔██╗██║█████╗░░╚█████╗░");
		System.out.println("░╚████╔╝░  ██╔══██║██║██╔══██╗██║░░░░░██║██║╚████║██╔══╝░░░╚═══██╗");
		System.out.println("░░╚██╔╝░░  ██║░░██║██║██║░░██║███████╗██║██║░╚███║███████╗██████╔╝");
		System.out.println("░░░╚═╝░░░  ╚═╝░░╚═╝╚═╝╚═╝░░╚═╝╚══════╝╚═╝╚═╝░░╚══╝╚══════╝╚═════╝░");
		System.out.println("\n\n");
		System.out.println("Login as... \n 1. Admin \n 2. User \nSign Up as ...\n 3.User");
		int login = sc.nextInt();
		sc.nextLine();
		switch (login) {

		case 1:
			System.out.println("Enter you Name : ");
			String adname = sc.nextLine();
			System.out.println("Enter Your Password : ");
			String adpass = sc.nextLine();
			String query = "select name,pass from admin where name=? AND pass=? ;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, adname);
			pst.setString(2, adpass);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				String pass = rs.getString(2);
				if ((adname.equals(name)) && (adpass.equals(pass))) {
					AdminController a = new AdminController();
					user_signin u = new user_signin();
					int f=1;

					while (f==1) {
						System.out.println(
								"What you wanna perform...? \n 1. VIEW BOOKINGS \n 2. VIEW USERS \n 3. DELETE USER \n 4. VIEW FLIGHTS \n 5. ADD FLIGHT \n 6. DELETE FLIGHT \n 7. EDIT FLIGHT \n 8.ADD USER \n 9.exit");
						int performAction = sc.nextInt();
						switch (performAction) {
						case 1:
							a.viewbookings();
							;
							break;
						case 2:
							a.viewusers();
							break;
						case 3:
							a.deleteuser();
							break;
						case 4:
							a.viewflights();
							break;
						case 5:
							a.addflight();
							break;
						case 6:
							a.deleteflight();
							break;
						case 7:
							a.editflight();
							break;
						case 8:
							u.insert();
							break;
						case 9:
							System.out.println("success!!!!");
							f=0;
							break;
						default:
							System.out.println("Invalid Option");
							break;

						}

					}

				} else {
					System.out.println("Invalid credentials");
				}

			}
			break;

		case 2:
			System.out.println("Enter you User Name : ");
			String empname = sc.nextLine();
			System.out.println("Enter Your Password : ");
			String emppass = sc.nextLine();
			query = "select * from user where username=? AND pass=? ;";
			pst = con.prepareStatement(query);
			pst.setString(1, empname);
			pst.setString(2, emppass);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String pass = rs.getString(4);
				if ((empname.equals(name)) && (emppass.equals(pass))) {
					UserController u = new UserController();
					while (true) {
						System.out.println(
								"What you wanna perform...? \n 1. VIEW FLIGHTS \n 2. BOOK FLIGHTS \n 3. CURRENT BOOKINGS");
						int performAction = sc.nextInt();
						switch (performAction) {
						case 1:
							u.viewflight();
							break;
						case 2:
							u.bookflight(id);
							break;
						case 3:
							u.currentbookings(id);
							break;
						default:
							System.out.println("Invalid Option");
							break;
						}

					}

				} else {
					System.out.println("Invalid credentials");
				}

			}
			break;

		case 3:
			user_signin e = new user_signin();
			e.insert();
			break;

		default:
			System.out.println("Invalid Option...");

			break;

		}
	}

	public static void main(String[] args) throws SQLException {

		Home h = new Home();
		h.CC();

	}
}

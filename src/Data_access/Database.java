package Data_access;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
// TODO: Auto-generated Javadoc


import present.Admin;
import present.ThietLapThongTin;

/**
 * kết nối với cơ sở dữ liệu.
 *
 * @author duonganh
 */

public class Database {
	
	/** The con. */
	private static Connection con = null ;
	
	
	/**
	 * Gets the con.
	 *
	 * @return the con
	 */
	public static Connection getCon() {
		return con;
	}
	
	/**
	 * kết nối tới cơ sở dữ liệu.
	 *
	 * @throws ClassNotFoundException the class not found exception
	 */
	public static void loadData() throws ClassNotFoundException {
		
		String local = null, data = null, user = null, pass = null;
		
		try {
			FileInputStream file = new FileInputStream("THIETLAP.txt");
			 Scanner scanner = new Scanner(file);
			 
			 while(scanner.hasNext()){
				 local = scanner.nextLine();
				 data = scanner.nextLine();
				 user = scanner.nextLine();
				 pass = scanner.nextLine();
			 }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Driver found!");
		String connectionUrl = "jdbc:sqlserver://"  + local + ";"
				+ "database=" + data +  ";" + "user=" + user +";" + "password=" + pass;
		// 3. Get a connection
		System.out.println("Connecting...");
		try {
			con = DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			ThietLapThongTin frame = new ThietLapThongTin();
			frame.setVisible(true);
		}
		System.out.println("Connected.");
	
	
	}
	
	/**
	 * Result.
	 *
	 * @param sql the sql
	 * @return the result set
	 */
	public static ResultSet result(String sql) {
		ResultSet rs = null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			return pstmt.executeQuery(	);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
}

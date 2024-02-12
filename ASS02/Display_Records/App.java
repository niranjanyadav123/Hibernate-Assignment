/*
 * Author - Niranjan Bhausaheb Yadav
 
 * Date - 13/02/2024
 
 * About Code - It is JDBC Code that reads the records from database and display on console.
 
 */

package com.niranjan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

	public static void main(String[] args) throws Exception {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			
			  Class.forName("com.mysql.cj.jdbc.Driver");
			
			  con = DriverManager.getConnection("jdbc:mysql://localhost/ajdb","root","root");
			
			  st = con.createStatement();
			
			  rs = st.executeQuery("select * from student");
			
			
			  System.out.println("RNO"+ "\t" + "Name" + "\t" + "Per" );
			  System.out.println("----------------------");
			
			  while (rs.next()) {
				  System.out.println(rs.getInt("rno") + "\t" + rs.getString("name") + "\t" + rs.getDouble("per"));
			  }
	
		} 
    catch (Exception e) {
			System.out.println("Probelm:: " + e.getMessage());
		}
	 
		finally {
			rs.close();
			con.close();
		}

	 }

}

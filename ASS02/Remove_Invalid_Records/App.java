/*
 * Author - Niranjan Bhausaheb Yadav
 
 * Date - 13/02/2024
 
 * About Code - It is JDBC Code that reads the records from demo.csv file and saved into database.
   But the record which having wrong values in column or less values according to column are not saved in database.
   
 */

package com.niranjan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App {

	public static void main(String[] args) throws Exception {
		
		FileReader fReader = null;
		BufferedReader bufferedReader = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String dbURL = "jdbc:mysql://localhost:3306/ajdb";
		String user = "root";
		String password = "root";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(dbURL,user,password);
			
			fReader = new FileReader("resources/demo.csv");
			
			bufferedReader = new BufferedReader(fReader);
			
			preparedStatement = connection.prepareStatement("insert into student values(?,?,?)");
			
			while(true) {
				String lineString = bufferedReader.readLine();
				
				if(lineString==null) break;
				
				String token[] = lineString.split(" ");
				
				try {
					
					  int rno = Integer.parseInt(token[0]);
					  String name = token[1];
					  double per = Double.parseDouble(token[2]);
					
					  preparedStatement.setInt(1, rno);
					  preparedStatement.setString(2, name);
					  preparedStatement.setDouble(3, per);
					
					  int sval= preparedStatement.executeUpdate();
					
					  if(sval==1) {
						  System.out.println("Record is saved!!");
					  }
					
				}
				catch (ArrayIndexOutOfBoundsException e) {
					lineString=bufferedReader.readLine();
				}
				
			}
      
		}
    catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			connection.close();
			fReader.close();
		}
	 

	 }

}

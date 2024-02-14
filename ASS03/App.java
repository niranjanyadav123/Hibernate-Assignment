/*
 * Author - Niranjan Bhausaheb Yadav
 
 * Date - 14/02/2024
 
 * About Code - Display the Passed and failed students from database using POJO Class and using two list.
   
 */

package com.niranjan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.niranjan.entities.Student;



public class App {

	public static void main(String[] args) throws Exception {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String dbURL = "jdbc:mysql://localhost:3306/ajdb";
		String user = "root";
		String password = "root";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(dbURL,user,password);
			preparedStatement = connection.prepareStatement("select * from student");
			
			resultSet = preparedStatement.executeQuery();
			
			List<Student> passedList = new ArrayList<Student>();
			List<Student> failedList = new ArrayList<Student>();
			
			while(resultSet.next()) {
				int rno = resultSet.getInt("rno");
				String name = resultSet.getString("name");
				double per = resultSet.getDouble("per");
				
				Student obStudent = new Student();
				obStudent.setRno(rno);
				obStudent.setName(name);
				obStudent.setPer(per);
				
				if(per>=50) passedList.add(obStudent);
				else failedList.add(obStudent);
			}
			
			System.out.println("Passed Student :: ");
			for(Student s:passedList) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer());
			}
			
			System.out.println("------------");
			
			System.out.println("Failed Student :: ");
			for(Student s:failedList) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer());
			}
			System.out.println("------------");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			resultSet.close();
			connection.close();
		}
		

	}

}

/*
 * Author - Niranjan Bhausaheb Yadav
 
 * Date - 14/02/2024
 
 * About Code - We display the records from database using Object of POJO Class (Student Class).
   
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
			
			List<Student> list = new ArrayList<Student>();
			
			while(resultSet.next()) {
				int rno = resultSet.getInt("rno");
				String name = resultSet.getString("name");
				double per = resultSet.getDouble("per");
				
				Student obStudent = new Student();
				obStudent.setRno(rno);
				obStudent.setName(name);
				obStudent.setPer(per);
				
				list.add(obStudent);
			}
			
			for(Student s:list) {
				System.out.println("Roll No : " + s.getRno());
				System.out.println("Name : " + s.getName());
				System.out.println("Per : " + s.getPer());
				System.out.println("------------");
			}
			
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

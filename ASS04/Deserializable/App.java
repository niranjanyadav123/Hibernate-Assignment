/*
 * Author - Niranjan Bhausaheb Yadav
 
 * Date - 16/02/2024
 
 * About Code - We Read binary data  from student.ser file and  deserialized it and display using Student object  i.e convert binary into object.

 */

package com.niranjan.deserialized;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.niranjan.entities.Student;

public class App {

	public static void main(String[] args) throws Exception{
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		Student student;
		
		try {
			fileInputStream = new FileInputStream("resources/student.ser");
			objectInputStream = new ObjectInputStream(fileInputStream);
			
			while ((student = (Student) objectInputStream.readObject()) != null) {
	
			
				System.out.println("Roll Number : " + student.getRno());
				System.out.println("Name : " + student.getName());
				System.out.println("Per : " +  student.getPer());
				System.out.println("---------------");
				
			}
		} 
		 catch (EOFException e) {
             System.out.println("Records are Finished");
      }  
       catch (ClassNotFoundException e) {
             e.printStackTrace();
      }
		
		finally {
			objectInputStream.close();
			fileInputStream.close();
		}
	}

}

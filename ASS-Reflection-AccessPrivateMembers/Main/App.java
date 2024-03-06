/*
 * Author - Niranjan Bhausaheb Yadav
 
 * Date - 7/03/2024
 
 * About Code - It is code in which we can access the private data members from Student class by using "Reflection" concept .
 
 */

package com.niranjan;

import java.lang.reflect.Field;

import com.niranjan.entities.Student;

public class App {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		
        try {
			
        	System.out.println("Access Private Members");
        	
        	//Create the object of student class
        	Student student = new Student(102,"BBB",78.0);
        	
        	
        	//Create the object of "Class" class
        	Class<Student> class1 = Student.class;
        	
        	
        	//Get the field names from Student Class separately. Give them data member name as parameter.
        	
        	Field declaredField1 = class1.getDeclaredField("rno");
        	Field declaredField2 = class1.getDeclaredField("name");
        	Field declaredField3 = class1.getDeclaredField("per");
        	
        	
        	//They are private data members. so , they need to make accessible by fields.
        	//Make them accessible by set true.
       
        	declaredField1.setAccessible(true);
        	declaredField2.setAccessible(true);
        	declaredField3.setAccessible(true);
        	
        	
        	//Get the respective data member value in respective field by using "get" method.
        	//We need to typecast it with  respect to our data type of members.
        	
        	Integer rnoString = (Integer)declaredField1.get(student);
        	String nameString = (String)declaredField2.get(student);
        	Double perDouble = (Double)declaredField3.get(student);
        	
        	//Print that value 
        	System.out.println("Rno : "+rnoString);
        	System.out.println("Name : "+nameString);
        	System.out.println("Per : "+perDouble);
        	
		} 
        catch (Exception e) {
			e.printStackTrace();
		}		

	}

}

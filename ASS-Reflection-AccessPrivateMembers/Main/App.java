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
        	Student student = new Student(103,"AAA",78.24);
        	
        	
        	//Create the object of "Class" class
        	Class<Student> class1 = Student.class;
        	
        	
        	//Get the field names from Student Class and put into array .
        	Field[] declaredFields = class1.getDeclaredFields();
        	
        	
        	//Iterate through the array of declare fields
        	for(Field f:declaredFields) {
        		
        		//They are private data members. so , they need to make accessible by fields.  Make them accessible by set true.
        		f.setAccessible(true);
        		
        		//Get the respective data member value in respective field by using "get" method.
        		Object object = f.get(student);
        		
        		//Print the data in object.
        		System.out.println(object);
        		
        	}
      
        	
		} 
        catch (Exception e) {
			e.printStackTrace();
		}		

	}

}

/*
OUTPUT - 
	Access Private Members
	103
	AAA
	78.24

*/	
	

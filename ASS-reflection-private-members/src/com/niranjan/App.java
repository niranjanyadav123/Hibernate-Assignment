package com.niranjan;

import java.lang.reflect.Field;

import com.niranjan.entities.Student;

public class App {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		
        try {
			
        	System.out.println("Access Private Members");
        	
        	Student student = new Student(101,"AAA",60.0);
        	
        	Class<Student> class1 = Student.class;
        	
        	Field declaredField1 = class1.getDeclaredField("rno");
        	Field declaredField2 = class1.getDeclaredField("name");
        	Field declaredField3 = class1.getDeclaredField("per");
        	
        	declaredField1.setAccessible(true);
        	declaredField2.setAccessible(true);
        	declaredField3.setAccessible(true);
        	
        	Integer rnoString = (Integer)declaredField1.get(student);
        	String nameString = (String)declaredField2.get(student);
        	Double perDouble = (Double)declaredField3.get(student);
        	
        	System.out.println("Rno : "+rnoString);
        	System.out.println("Name : "+nameString);
        	System.out.println("Per : "+perDouble);
        	
		} 
        catch (Exception e) {
			// TODO: handle exception
		}		

	}

}

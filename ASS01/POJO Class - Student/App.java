/*
 * Author - Niranjan Bhausaheb Yadav
 
 * Date - 13/02/2024
 
 * About Code -We create the Objecct of pojo class and set and get the data by setters and getters.
   
 */

package com.niranjan;

import com.niranjan.student.Student;

public class App {

	public static void main(String[] args) {
		
          Student obStudent = new Student();
          
          obStudent.setRno(100);
          obStudent.setName("Niranjan");
          obStudent.setPer(95);
          
          System.out.println("Roll number : "+obStudent.getRno());
          System.out.println("Name : "+obStudent.getName());
          System.out.println("Per : "+obStudent.getPer());
          
          System.out.println(obStudent);
          
	}

}

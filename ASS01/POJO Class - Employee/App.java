/*
 * Author - Niranjan Bhausaheb Yadav
 
 * Date - 13/02/2024
 
 * About Code - We create the Objecct of pojo class and set and get the data by setters and getters.
   
 */

package com.niranjan;

import com.niranjan.employee.Employee;

public class App {

	public static void main(String[] args) {
		Employee obEmployee = new Employee();
		
		obEmployee.setEno(100);
		obEmployee.setEname("Niranjan");
		obEmployee.setSalary(100000);
		obEmployee.setCity("Pune");
		
		System.out.println("Eno : "+ obEmployee.getEno());
		System.out.println("Name : "+ obEmployee.getEname());
		System.out.println("Salary : "+ obEmployee.getSalary());
		System.out.println("City : "+ obEmployee.getCity());
		
		System.out.println(obEmployee);

	}

}

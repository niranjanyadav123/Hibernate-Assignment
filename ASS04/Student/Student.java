/*
 * Author - Niranjan Bhausaheb Yadav
 
 * Date - 13/02/2024
 
 * About Code - We create the Student Class which implements the serializable interface.
   
 */

package com.niranjan.entities;

import java.io.Serializable;

public class Student implements Serializable {
     private static final long serialVersionUID = 1L;
     
     private int rno;
     private String name;
     private double per;
     
     
	public int getRno() {
		return rno;
	}
	
	public void setRno(int rno) {
		this.rno = rno;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPer() {
		return per;
	}
	
	public void setPer(double per) {
		this.per = per;
	}

	@Override
	public String toString() {
		return "student [rno=" + rno + ", name=" + name + ", per=" + per + "]";
	}
     
     
}


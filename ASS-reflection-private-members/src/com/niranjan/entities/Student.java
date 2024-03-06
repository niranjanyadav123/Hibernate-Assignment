package com.niranjan.entities;

public class Student {
    private Integer rno;
    private String name;
    private Double per;
    
    
	public Student(Integer rno, String name, Double per) {
		super();
		this.rno = rno;
		this.name = name;
		this.per = per;
	}


	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", per=" + per + "]";
	}
    
    
}

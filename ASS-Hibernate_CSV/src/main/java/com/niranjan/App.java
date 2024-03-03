package com.niranjan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.niranjan.entities.Student;

public class App 
{
    public static void main( String[] args ) 
    {
        FileReader fileReader=null;
        BufferedReader bufferedReader = null;
        
    	Configuration configuration=null;
    	SessionFactory sessionFactory=null;
    	Session session=null;
    	Transaction transaction=null;
    	
    	try {
    		
    		
    		  try {
    			  fileReader = new FileReader("D:\\MySpace\\Niranjan\\JAVA\\Hibernate\\ASS-Hibernate_CSV\\src\\main\\resources\\Data.csv");
    	    		bufferedReader = new BufferedReader(fileReader);
			  } 
    		  catch (IOException e) {
				 System.out.println("File Not Found !!");
			  }
    		  
    		  
			
    		configuration = new Configuration();
    		configuration.configure();
    		
    		sessionFactory = configuration.buildSessionFactory();
    		
    		session = sessionFactory.openSession();
    		
    		transaction = session.beginTransaction();
    		
    		String string=null;
    		
    		while(true) {
    			string = bufferedReader.readLine();
    			
    			if(string==null) break;
    			
    			String token[] = string.split(" ");
    			
    			
    			if(token.length<3) { 
    				System.out.println("Record Rejected " + string);
    				continue;   
    			}
    			    			
    			
    			Student student = new Student();
    			try {
    				student.setRno(Integer.parseInt(token[0]));
				}
    			catch (Exception e) {
    				System.out.println("Record Rejected " + string);
    				continue; 
				}
    			
    			student.setName(token[1]);
    			
    			try {
    				student.setPer(Double.parseDouble(token[2]));
				}
    			catch (Exception e) {
    				System.out.println("Record Rejected " + string);
    				continue; 
				}
    			
    			
    			session.save(student);
    			
    			System.out.println("Record is saved !!");
    			
    		}
    		
    		transaction.commit();
    		
		} 
    	catch (Exception e) {
			transaction.rollback();
		}
    	
    	finally {
    		try {
    			fileReader.close();
    			bufferedReader.close();
			  } 
  		  	catch (Exception e) {
  		  		System.out.println("File Not Found !!");
			 }

    		session.close();
			sessionFactory.close();
		}
    	
    	
    }
}

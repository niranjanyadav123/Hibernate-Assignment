/*
 * Author - Niranjan Bhausaheb Yadav
 
 * Date - 16/02/2024
 
 * About Code - We Read records from CSV file and  serialized the record by using student object  i.e convert object into  binary.

 */

package com.niranjan.serailized;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;

import com.niranjan.entities.Student;

public class App {
    public static void main(String args[]) throws Exception {
    	FileOutputStream fileOutputStream  = null;
    	ObjectOutputStream objectOutputStream=null;
    	FileReader fReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileOutputStream = new FileOutputStream("resources/student.ser");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			fReader =new FileReader("resources/student.csv");
			bufferedReader = new BufferedReader(fReader);
			
			while(true) {
				String string = bufferedReader.readLine();
				if(string==null) break;
				
				String token[] = string.split(" ");
				
				Student student = new Student();
				
				student.setRno(Integer.parseInt(token[0]));
				student.setName(token[1]);
				student.setPer(Double.parseDouble(token[2]));
				
				objectOutputStream.writeObject(student);
				
				System.out.println("Object has been serialized !!");
			
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			bufferedReader.close();
			fReader.close();
			objectOutputStream.close();
			fileOutputStream.close();
		}
		
    }
}

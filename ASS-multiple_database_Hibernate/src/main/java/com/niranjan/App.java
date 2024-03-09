package com.niranjan;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.niranjan.entities.Student;
import com.niranjan.entities.Teacher;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration();
        configuration.configure("myconfig.cfg.xml");
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        Student sobStudent = new Student();
        sobStudent.setRno(101);
        sobStudent.setName("AAA");
        sobStudent.setPer(80.00);
        
        Teacher teacher = new Teacher();
        teacher.setTno(1);
        teacher.setName("PPP");
        teacher.setSalary(90.00);
        
        session.save(sobStudent);
        session.save(teacher);
        
        transaction.commit();
        
        session.close();
        sessionFactory.close();
        
        System.out.println("Record Insert !!");
    }
}

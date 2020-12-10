package org.demo.hibernate.app;

import org.demo.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			Student student = new Student("Sri", "Charan", "sricharan@melluli.com");
			System.out.println("Student created");
			
			//start a transaction
			session.beginTransaction();
			System.out.println("Transaction started");
			
			//save the student object
			session.save(student);
			System.out.println("Student saved");
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Data committed");
		}
		finally {
			factory.close();
		}
	}

}

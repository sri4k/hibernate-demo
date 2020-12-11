package org.demo.hibernate.app;

import org.demo.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
		//create 4 student objects
		Student student1 = new Student("Paul", "Wall", "paul@gmail.com");
		Student student2 = new Student("John", "Doe", "john@yahoo.com");
		Student student3 = new Student("Mary", "Public", "mary@hotmail.com");
		Student student4 = new Student("Bonita", "Applebum", "bonita@gmail.com");
		System.out.println("Students created");
		
		//start a transaction
		session.beginTransaction();
		
		//save the student object
		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(student4);
		System.out.println("Students saved");
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("Data committed");
		}
		finally {
		factory.close();
		}
	}

}

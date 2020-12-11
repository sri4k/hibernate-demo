package org.demo.hibernate.app;

import java.util.List;

import org.demo.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//query all students
			@SuppressWarnings("unchecked")
			List<Student> studentList = session
										.createQuery("from Student")
										.getResultList();
			displayStudents(studentList);
			
			//query like 'gmail.com'
			studentList = session
						.createQuery("from Student s where s.email LIKE '%gmail.com'")
						.getResultList();
			displayStudents(studentList);
	
			//query lastname
			studentList = session
					.createQuery("from Student s where " 
							+ "s.lastName = 'Doe' OR s.firstName = 'Daffy'")
					.getResultList();
			displayStudents(studentList);
		
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> studentList) {
		System.out.println("\n");
		for(Student student : studentList) {
			System.out.println(student);
		}
	}

}

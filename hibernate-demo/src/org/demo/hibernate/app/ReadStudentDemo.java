package org.demo.hibernate.app;

import org.demo.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			Student student = new Student("Donald", "Duck", "donald@gmail.com");
			
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Student created");
			
			//get the students id
			int id = student.getId();
			System.out.println("Student id = " + id);
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, id);
			System.out.println(myStudent);
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}

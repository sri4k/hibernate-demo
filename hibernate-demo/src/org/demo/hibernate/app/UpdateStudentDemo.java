package org.demo.hibernate.app;

import org.demo.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int id = 1;

			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//get student from id
			Student student = session.get(Student.class, id);
			student.setFirstName("Scooby");
			student.setLastName("Doo");
			student.setEmail("scoobydoo@gmail.com");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student s set " 
							+ "s.email = 'bonita@rediffmail.com' " 
							+ "where s.firstName = 'Bonita'")
							.executeUpdate();
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}

package org.demo.hibernate.app;

import org.demo.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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
//			Student student = session.get(Student.class, id);
//			session.delete(student);
//			System.out.println("Deleted " + student);
			
			session.createQuery("delete from Student " 
						+ "where id = 2").executeUpdate();
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}

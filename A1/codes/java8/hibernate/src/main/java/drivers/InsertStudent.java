package drivers;

import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertStudent {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.
				createEntityManagerFactory("demo");
		
		EntityManager em=
				emf.createEntityManager();
		
		//Only required for DML operations
		EntityTransaction et=em.getTransaction();
		
		et.begin();
			
		Student s=new Student();
		
		s.setName("krish");
		s.setStandard("12th");
		s.setSection('B');
		s.setEmail("krish@gmail.com");
		
		em.persist(s);
		
		System.out.println("Student inserted successfully!");
		
		et.commit();
	}
}

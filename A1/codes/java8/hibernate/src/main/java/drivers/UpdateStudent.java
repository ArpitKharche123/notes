package drivers;

import java.beans.PersistenceDelegate;

import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdateStudent {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("demo");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
			//Fetch the student record to be updated
			Student student = em.find(Student.class, 1);
			
			if (student!=null) {
				//Update
				student.setName("Smith");
				student.setEmail("smith@gmail.com");
				
				em.merge(student);
				System.out.println("Student updated successfully");
			}else {
				System.err.println("Student not found");
			}
			
		et.commit();
	}
}

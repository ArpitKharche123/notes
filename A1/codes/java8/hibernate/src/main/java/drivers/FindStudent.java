package drivers;

import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindStudent {
	public static void main(String[] args) {
		EntityManagerFactory emf=
			Persistence
			.createEntityManagerFactory("demo");
		
		EntityManager em=emf.createEntityManager();
		
		Student student = em.find(Student.class, 2);
		
		if (student!=null) {
			System.out.println(student);
		}
		else {
			System.err.println("Student not found for the given id");
		}
		
		
	}
}

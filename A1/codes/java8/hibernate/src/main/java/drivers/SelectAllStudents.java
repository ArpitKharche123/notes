package drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class SelectAllStudents {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence
				.createEntityManagerFactory("demo");
			
			EntityManager em=emf.createEntityManager();
		
			//Creating a JPQL query
			Query query 
			= em.createQuery("Select s from Student s");
			
			List students = query.getResultList();
			
			if (!students.isEmpty()) {
				students.stream()
				.forEach(System.out::println);
			}else {
				System.err.println("Students does not exists");
			}
	}
}

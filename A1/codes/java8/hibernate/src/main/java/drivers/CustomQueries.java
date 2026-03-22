package drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CustomQueries {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence
				.createEntityManagerFactory("demo");
			
			EntityManager em=emf.createEntityManager();
		
			//Creating a dynamic JPQL query
			// ?1 is a positional parameter
			// :name is a named parameter
			Query query 
			= em.createQuery("Select s from Student s "
					+ "where s.email=?1 "
					+ "and s.name=:name");
			//Setting the values for the parameters
			query.setParameter(1, "krish@gmail.com");
			query.setParameter("name", "krish");
			
			List students = query.getResultList();
			
			if (!students.isEmpty()) {
				students.stream()
				.forEach(System.out::println);
			}else {
				System.err.println("Students does not exists");
			}
	}
}

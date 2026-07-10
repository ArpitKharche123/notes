package drivers;

import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CustomQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf 
		= Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();
		
		//dynamic JPQL
		Query query = em.createQuery("Select c from Customer c "
				+ "where c.name= ?1 "//positional parameter
				+ "and c.address = :add"//named parameter
				,Customer.class);
		
		query.setParameter(1, "Dipti");
		query.setParameter("add", "Wakad");
		
		query.getResultList()
			.forEach(System.out::println);
	}
}

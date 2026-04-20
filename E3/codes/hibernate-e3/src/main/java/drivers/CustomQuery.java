package drivers;

import entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CustomQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf=
		Persistence.createEntityManagerFactory("hibernate");
								
		EntityManager em=emf.createEntityManager();
		
		//Dynamic JPQL queries
		Query query = em.createQuery
				("Select b from Book b "
				+ "where b.name=?1 "
				+ "and b.author=:author ",
				Book.class);
		
		query.setParameter(1, "book1");
		//?1 positional paramater
		
		query.setParameter("author", "author1");
		//:author named parameter
		
		query.getResultList()
		.stream()
		.forEach(System.out::println);
		
	}
}

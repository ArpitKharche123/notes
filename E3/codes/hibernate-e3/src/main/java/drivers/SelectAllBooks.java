package drivers;

import java.util.List;

import entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SelectAllBooks {
	public static void main(String[] args) {
		EntityManagerFactory emf=
		Persistence.createEntityManagerFactory("hibernate");
						
		EntityManager em=emf.createEntityManager();
		
		//JPQL: Java Persistence Query Language
		
		List<Book> books = em.createQuery("Select b from Book b"
				,Book.class)
			.getResultList();
		
		books.stream()
		.forEach(System.out::println);
	}
}

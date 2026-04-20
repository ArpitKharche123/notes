package drivers;

import entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchBook {
	public static void main(String[] args) {
		EntityManagerFactory emf=
		Persistence.createEntityManagerFactory("hibernate");
				
		EntityManager em=emf.createEntityManager();
		
		Book book = em.find(Book.class, 1);
		
		System.out.println(book);
	}
}

package drivers;

import entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertBook {
	public static void main(String[] args) {
		EntityManagerFactory emf=
		Persistence.createEntityManagerFactory("hibernate");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		Book b=new Book();
		
		b.setName("book2");
		b.setAuthor("author2");
		b.setPrice(680);
		
		et.begin();
		
		em.persist(b);
		System.out.println("Book inserted successfully");
		
		et.commit();
	}
}

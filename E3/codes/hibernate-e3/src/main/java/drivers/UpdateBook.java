package drivers;

import entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdateBook {
	public static void main(String[] args) {
		EntityManagerFactory emf=
		Persistence.createEntityManagerFactory("hibernate");
				
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		
		Book book = em.find(Book.class, 2);
		if (book!=null) {
			
			book.setPrice(1000);
			System.out.println("Updated");
			
		}else {
			System.err.println("Book does not exists");
		}
		
		et.commit();
	}
}

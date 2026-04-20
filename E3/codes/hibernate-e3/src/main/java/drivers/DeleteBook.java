package drivers;

import entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DeleteBook {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("hibernate");
						
				EntityManager em=emf.createEntityManager();
				
				EntityTransaction et=em.getTransaction();
				
				et.begin();
				
				Book book = em.find(Book.class, 1);
				if (book!=null)  {
					
					em.remove(book);
					
					System.out.println("Deleted");
					
				}else {
					System.err.println("Book does not exists");
				}
				
				et.commit();
	}
}

package o2m_bi.drivers;


import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2m_bi.entities.Book;
import o2m_bi.entities.Library;

public class InsertLibraryBook {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("one_to_many_to_one");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Library l1 = new Library();
		l1.setName("Bhandarkar Library");
		l1.setAddress("Pune");
		
		Book b1 = new Book();
		b1.setTitle("Wings of Fire");
		b1.setAuthor("Sumit");
		b1.setPrice(150);
		
		Book b2 = new Book();
		b2.setTitle("Mruntunjay");
		b2.setAuthor("Shivaji");
		b2.setPrice(850);
		
		//one to many bi - directional mapping
		
		List<Book> books = Arrays.asList(b1,b2);
		
		l1.setBooks(books);
		
		b1.setLibrary(l1);
		b2.setLibrary(l1);
		
		et.begin();
			em.persist(l1);
			em.persist(b1);
			em.persist(b2);
		et.commit();
	}
}

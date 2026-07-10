package o2m.drivers;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2m.entites.Book;
import o2m.entites.Library;

public class InsertLibraryBooks {
	public static void main(String[] args) {
		EntityManagerFactory emf =
		Persistence.createEntityManagerFactory("one_to_many");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Library library = new Library();
		library.setName("Lib1");
		library.setAddress("wakad");
		
		Book book1=new Book();
		book1.setTitle("Java");
		book1.setAuthor("James Gosling");
		book1.setPrice(1000);
		
		Book book2=new Book();
		book2.setTitle("C++");
		book2.setAuthor("Swanand");
		book2.setPrice(1000);
		
		List<Book> books = Arrays.asList(book1,book2);
		
		library.setBooks(books);
		
		Library library2 = new Library();
		library2.setName("Lib2");
		library2.setAddress("kalewadi");
		
		Book book3=new Book();
		book3.setTitle("C");
		book3.setAuthor("John");
		book3.setPrice(100);
		
		Book book4=new Book();
		book4.setTitle("Rust");
		book4.setAuthor("Michael");
		book4.setPrice(1000);
		
		Book book5=new Book();
		book5.setTitle("GoLang");
		book5.setAuthor("Carl");
		book5.setPrice(1001);
		
		List<Book> books2 = Arrays.asList(book3,book4,book5);
		library2.setBooks(books2);
		
		et.begin();
			for(Book b:books) {
				em.persist(b);
			}
		  em.persist(library);
		  
		  for(Book b:books2) {
			  em.persist(b);
		  }
		  em.persist(library2);
		et.commit();
	}
}

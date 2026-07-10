package o2m.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import o2m.entites.Library;

public class FetchLibraryBooks {
	public static void main(String[] args) {
		EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("one_to_many");
		EntityManager em = emf.createEntityManager();
		
//		Library library = em.find(Library.class, 1);
//		
//		library.getBooks().forEach(System.out::println);
		
		em.createQuery("Select l from Library l "
				+ "join fetch l.books",Library.class)
		  .getResultList()
		  .forEach(
			  l->{
				  System.out.println("Library: "+l.getName());
				  System.out.println("Books: ");
				  l.getBooks()
				   .forEach(
						   b->{
							   System.out.println(
									   "Title: "+b.getTitle()
									   +"\nPrice: "+b.getPrice()
									   +"\n");
						   }
						   );
			  }
			  );
	}
}

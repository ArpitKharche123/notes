package o2m_bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2m_bi.entities.Book;
import o2m_bi.entities.Library;

import java.util.List;

public class InsertLibraryBook {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "o2m_bi");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Library library = new Library();
        library.setName("Satyam library");
        library.setAddress("Kalewadi Chauk, pune");

        Book book1 = new Book();
        book1.setTitle("Learning Java");
        book1.setAuthor("James Gosling");
        book1.setPrice(200);
        
        Book book2 = new Book();
        book2.setTitle("Learning Python");
        book2.setAuthor("Richard");
        book2.setPrice(130);

        List<Book> books = List.of(book1, book2);

        //one to many bi-directional mapping
        library.setBooks(books);
        books.forEach(b->b.setLibrary(library));

        try{
            et.begin();
                em.persist(library);
                books.forEach(em::persist);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}

package o2m_bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import o2m_bi.entities.Book;
import o2m_bi.entities.Library;

import java.util.List;

public class FetchLibraryBooks {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "o2m_bi");
        EntityManager em = emf.createEntityManager();

        List<Library> libraries = em.createQuery("""
                        from Library l
                        join fetch l.books
                        """, Library.class)
                .getResultList();

        System.out.println("Library details: ");
        libraries.forEach(
                l->{
                    List<Book> books = l.getBooks();
                    System.out.printf("""
                            Name: %s
                            Address: %s
                            Book details: 
                            """,
                            l.getName(),l.getAddress());
                    books.forEach(
                            book->{
                                System.out.printf("""
                                        Title: %s
                                        Author: %s
                                        Price: %.2f
                                        ----------------
                                        """,book.getTitle(),
                                        book.getAuthor(),
                                        book.getPrice());
                            }
                    );
                }
        );
    }
}

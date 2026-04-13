package edu.lms_a1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.lms_a1.entity.Book;

@Repository
public interface BookRepository 
extends JpaRepository<Book, Integer> {
	
	public Book findByTitleAndAuthor(String title,String author);
	// Select b from Book b
	//where b.title=:title and b.author=:author
	
	@Query("Select b from Book b where b.price=:price")
	public List<Book> getBooksByPrice(double price);
}

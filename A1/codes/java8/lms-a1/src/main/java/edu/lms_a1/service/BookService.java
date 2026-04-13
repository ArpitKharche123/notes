package edu.lms_a1.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.lms_a1.dto.UpdateBookPriceDto;
import edu.lms_a1.dto.request.BookRequestDto;
import edu.lms_a1.dto.response.BookResponseDto;

public interface BookService {
	
	public BookResponseDto getBookById(int id);
	
	public List<BookResponseDto> getAllBooks();
	
	public BookResponseDto getBookByTitleAndAuthor(String title,String author);
	
	public List<BookResponseDto> getBooksByPrice(double price);
	
	//Pagination
	public Page<BookResponseDto> getBooks(Pageable p);
	
	public BookResponseDto addBook(BookRequestDto dto);
	
	public BookResponseDto updateBook(int id,BookRequestDto dto);
	
	public BookResponseDto updateBookPrice(int id,UpdateBookPriceDto dto);
	
	public void deleteBook(int id);
}

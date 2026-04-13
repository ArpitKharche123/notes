package edu.lms_a1.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.lms_a1.dto.UpdateBookPriceDto;
import edu.lms_a1.dto.request.BookRequestDto;
import edu.lms_a1.dto.response.BookResponseDto;
import edu.lms_a1.entity.Book;
import edu.lms_a1.exception.ResourceNotFoundException;
import edu.lms_a1.mapper.BookMapper;
import edu.lms_a1.repository.BookRepository;
import edu.lms_a1.service.BookService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
	
	private final BookRepository bookRepository;
	private final BookMapper mapper;
	
	@Override
	public BookResponseDto getBookById(int id) {
		
		Book book = bookRepository.findById(id)
				.orElseThrow(
						()->
			new ResourceNotFoundException(
				"Book not found with given id: "+id)
			);
		return mapper.toDto(book);
	}

	@Override
	public List<BookResponseDto> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books.stream()
				.map(mapper::toDto)
				.toList(); 
	}
	

	@Override
	public BookResponseDto getBookByTitleAndAuthor(String title, String author) {
		Book book = bookRepository.findByTitleAndAuthor(title, author);
		return mapper.toDto(book);
	}
	
	@Override
	public List<BookResponseDto> getBooksByPrice(double price) {
		List<Book> books = bookRepository.getBooksByPrice(price);
		
		return books.stream()
				.map(mapper::toDto)
				.toList(); 
	} 
	
	@Override
	public Page<BookResponseDto> getBooks(Pageable p) {
		Page<Book> books = bookRepository.findAll(p);
		return books.map(mapper::toDto);
	} 

	@Override
	public BookResponseDto addBook(BookRequestDto dto) {
		Book book= mapper.toEntity(dto);
		
		Book newBook = bookRepository.save(book);
		
		return mapper.toDto(newBook);
	}

	@Override
	public BookResponseDto updateBook(int id, BookRequestDto dto) {
		
		Book book = bookRepository.findById(id)
		.orElseThrow();
		
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setPrice(dto.getPrice());
		book.setYear(dto.getYear());
		
		Book updated = bookRepository.save(book);
		
		return mapper.toDto(updated);
	}

	@Override
	public BookResponseDto updateBookPrice(int id, UpdateBookPriceDto dto) {
		Book book=bookRepository.findById(id)
				.orElseThrow();
		
		book.setPrice(dto.getPrice());
		
		Book b = bookRepository.save(book);
		
		return mapper.toDto(b);
		
	}

	@Override
	public void deleteBook(int id) {
		//bookRepository.deleteById(id);
		
		//or
		
		Book book=bookRepository.findById(id)
				.orElseThrow();
		
		bookRepository.delete(book);
	}


}

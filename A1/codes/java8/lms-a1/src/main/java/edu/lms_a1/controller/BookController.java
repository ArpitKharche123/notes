package edu.lms_a1.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.lms_a1.dto.UpdateBookPriceDto;
import edu.lms_a1.dto.request.BookRequestDto;
import edu.lms_a1.dto.response.ApiResponseDto;
import edu.lms_a1.dto.response.BookResponseDto;
import edu.lms_a1.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/book")
public class BookController {
	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponseDto<BookResponseDto>> 
		getBook(@PathVariable int id) {
		BookResponseDto book = bookService.getBookById(id);

		return ResponseEntity.ok(
				ApiResponseDto.success(
						book,
						"Book fetched successfully")	
				);
	}

	@GetMapping
	public ResponseEntity<ApiResponseDto<List<BookResponseDto>>>
	getAllBook() {
		 List<BookResponseDto> books = bookService.getAllBooks();
		 
		 return ResponseEntity.ok(
				 ApiResponseDto.success(
						 books, "Books fetched successfully")
				 );
	}
	
	@GetMapping("/search")
	public ResponseEntity<ApiResponseDto<BookResponseDto>>
	getBookByTitleAndAuthor(
			@RequestParam @NotBlank(message = "title is required")
			String title,
			@RequestParam @NotBlank(message = "author is required")
			String author
			){
		
		BookResponseDto book 
		= bookService.getBookByTitleAndAuthor(title, author);
		
		return ResponseEntity.ok(
				ApiResponseDto.success(book, "Book fetched successfully")
				);
	} 
	
	@GetMapping("/price")
	public ResponseEntity<ApiResponseDto<List<BookResponseDto>>>
	getBooksByPrice(
			@RequestParam @Positive(message = "price must be greater"
					+ " than 0")double price){
		List<BookResponseDto> books 
		= bookService.getBooksByPrice(price);
		
		return ResponseEntity.ok(
				ApiResponseDto.success(books,
				"Books with given price fetched successfully")
				);
	}
	
	@GetMapping("/filter")
	public ResponseEntity<ApiResponseDto<List<BookResponseDto>>>
	getBooks(
		@RequestParam(defaultValue = "0")	int page,
		@RequestParam(defaultValue = "2")	int size,
		@RequestParam(defaultValue = "title")String sortBy,
		@RequestParam(defaultValue = "asc")	String sortDirection
			){
		//Sorting
		Sort sort= (sortDirection.equalsIgnoreCase("desc"))
				? Sort.by(sortBy).descending()
				: Sort.by(sortBy).ascending();
		
		Pageable p = PageRequest.of(page, size, sort);
		
		Page<BookResponseDto> books = bookService.getBooks(p);
		
		return ResponseEntity.ok(
				ApiResponseDto.success(books.toList(),
						"Books fetched successfully")
				);
	}
	
	@PostMapping
	public ResponseEntity<ApiResponseDto<BookResponseDto>>
	addBook(@Valid @RequestBody BookRequestDto bookDto) {
		
		BookResponseDto book = bookService.addBook(bookDto);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(
				ApiResponseDto.created(
						book,
						"Book added successfully")	
				);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponseDto<BookResponseDto>>
	updateBook(@PathVariable int id,
			@Valid @RequestBody BookRequestDto dto) {
		
		BookResponseDto book = bookService.updateBook(id, dto);
		
	return ResponseEntity.ok(
			ApiResponseDto.success(
					book,
					"Book updated successfully")
			);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ApiResponseDto<BookResponseDto>> 
	updateBookPrice(@PathVariable int id,
			@Valid @RequestBody UpdateBookPriceDto dto,
			@RequestHeader(value = "Prefer",required = false)
			String prefer) {
		
		BookResponseDto book = bookService.updateBookPrice(id, dto);
		
		if ("return=representation".equals(prefer)) {
			return ResponseEntity.ok(
					ApiResponseDto.success(book,
							"Price updated successfully")
					);
		}
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
		
		return ResponseEntity.noContent().build();
	}
}

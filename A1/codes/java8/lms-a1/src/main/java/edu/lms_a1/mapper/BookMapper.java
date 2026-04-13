package edu.lms_a1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.lms_a1.dto.request.BookRequestDto;
import edu.lms_a1.dto.response.BookResponseDto;
import edu.lms_a1.entity.Book;

@Component
public class BookMapper {
	@Autowired
	private ModelMapper mapper;
	
	public BookResponseDto toDto(Book book) {
		return mapper.map(book, BookResponseDto.class);
	}
	
	public Book toEntity(BookRequestDto dto) {
		return mapper.map(dto, Book.class);
	}
}

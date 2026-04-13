package edu.lms_a1.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDto {
	private int id;
	private String title;
	private String author;
	private double price;
	private int year;
}

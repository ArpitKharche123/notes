package edu.ecom_e3.dto.response;

import lombok.Data;

@Data
public class ProductResponseDto {
	private Long id;

	private String name;

	private String description;
	private Double price;

	private Long quantity;
}

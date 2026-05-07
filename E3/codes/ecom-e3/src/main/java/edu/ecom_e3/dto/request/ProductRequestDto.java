package edu.ecom_e3.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductRequestDto {
	@NotBlank(message = "Name cannot be blank")
	private String name;
	
	private String description;
	
	@Min(value = 1,message = "Price must be greater than 0")
	private Double price;
	
	@Min(value = 0,message = "Quantity must be atleast zero")
	private Long quantity;
}

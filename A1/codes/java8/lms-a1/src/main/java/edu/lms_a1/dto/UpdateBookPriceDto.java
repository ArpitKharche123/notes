package edu.lms_a1.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookPriceDto {
	@Min(value = 1,message = "Price must be greater than 0")
	private Double price;
}

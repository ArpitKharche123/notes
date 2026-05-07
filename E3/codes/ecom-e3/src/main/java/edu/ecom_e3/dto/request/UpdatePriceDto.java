package edu.ecom_e3.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class UpdatePriceDto {
	@Min(value = 1,message = "Price must be greater than 0")
	private Double price;
}

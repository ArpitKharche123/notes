package edu.springboot_e4.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpdateAgeDto {
	@Positive
	private int age;
}

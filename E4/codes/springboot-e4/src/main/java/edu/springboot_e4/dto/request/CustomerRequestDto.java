package edu.springboot_e4.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CustomerRequestDto {
	@NotBlank(message = "name should not be blank")
	private String name;
	@Positive
	private int age;
	@NotBlank
	private String gender;
	private long phone;
}

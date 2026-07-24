package edu.springboot_e4.dto.response;

import lombok.Data;

@Data
public class CustomerResponseDto {
	private long id;
	private String name;
	private int age;
	private String gender;
	private long phone;
}

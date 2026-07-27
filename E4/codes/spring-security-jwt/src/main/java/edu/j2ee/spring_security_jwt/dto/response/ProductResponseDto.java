package edu.j2ee.spring_security_jwt.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
	private Long id;
    private String name;
    private Double price;
}

package edu.j2ee.spring_security_jwt.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
	private String name;
    private Double price;
}

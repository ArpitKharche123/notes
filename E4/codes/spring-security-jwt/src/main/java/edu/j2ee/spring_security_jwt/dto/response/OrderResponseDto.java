package edu.j2ee.spring_security_jwt.dto.response;

import java.util.List;

import edu.j2ee.spring_security_jwt.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
	private Long id;
	private UserDto user; // nested user info
	private List<ProductResponseDto> products; // list of products
}

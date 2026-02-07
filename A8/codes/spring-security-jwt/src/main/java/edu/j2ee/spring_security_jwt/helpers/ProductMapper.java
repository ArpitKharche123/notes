package edu.j2ee.spring_security_jwt.helpers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import edu.j2ee.spring_security_jwt.dto.request.ProductRequestDto;
import edu.j2ee.spring_security_jwt.dto.response.ProductResponseDto;
import edu.j2ee.spring_security_jwt.entities.Product;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductMapper {
	private final ModelMapper mapper;

	public ProductResponseDto toDto(Product product) {
		return mapper.map(product, ProductResponseDto.class);
	}

	public Product toEntity(ProductRequestDto product) {
		return mapper.map(product, Product.class);
	}
}

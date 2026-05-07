package edu.ecom_e3.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.ecom_e3.dto.request.ProductRequestDto;
import edu.ecom_e3.dto.response.ProductResponseDto;
import edu.ecom_e3.entity.Product;

@Component
public class ProductMapper {
	@Autowired
	private ModelMapper mapper;

	public ProductResponseDto toDto(Product product) {
		return mapper.map(product, ProductResponseDto.class);
	}

	public Product toEntity(ProductRequestDto dto) {
		return mapper.map(dto, Product.class);
	}

	public void map(ProductRequestDto dto, Product p) {
		mapper.map(dto, p);
	}
}

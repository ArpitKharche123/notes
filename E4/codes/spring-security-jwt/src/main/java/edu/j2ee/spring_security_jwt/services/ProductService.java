package edu.j2ee.spring_security_jwt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.j2ee.spring_security_jwt.dto.request.ProductRequestDto;
import edu.j2ee.spring_security_jwt.dto.response.ProductResponseDto;
import edu.j2ee.spring_security_jwt.entities.Product;
import edu.j2ee.spring_security_jwt.helpers.ProductMapper;
import edu.j2ee.spring_security_jwt.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository repo;
	private final ProductMapper mapper;

	public ProductResponseDto save(ProductRequestDto product) {
		Product prod = repo.save(mapper.toEntity(product));
		return mapper.toDto(prod);
	}

	public List<ProductResponseDto> getAll() {
		return repo.findAll().stream().map(mapper::toDto).toList();
	}
}

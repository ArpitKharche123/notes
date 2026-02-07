package edu.j2ee.spring_security_jwt.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.j2ee.spring_security_jwt.dto.request.ProductRequestDto;
import edu.j2ee.spring_security_jwt.dto.response.ProductResponseDto;
import edu.j2ee.spring_security_jwt.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping
	public ProductResponseDto create(@RequestBody ProductRequestDto product) {
		return service.save(product);
	}

	@GetMapping
	public List<ProductResponseDto> getAll() {
		return service.getAll();
	}
}

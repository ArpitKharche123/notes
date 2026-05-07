package edu.ecom_e3.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.ecom_e3.dto.request.ProductRequestDto;
import edu.ecom_e3.dto.request.UpdatePriceDto;
import edu.ecom_e3.dto.response.ProductResponseDto;
import edu.ecom_e3.entity.Product;
import edu.ecom_e3.exception.NotFoundException;
import edu.ecom_e3.mapper.ProductMapper;
import edu.ecom_e3.repository.ProductRepository;
import edu.ecom_e3.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	private ProductMapper mapper;
	
	public ProductServiceImpl(
			ProductRepository productRepository,
			ProductMapper mapper) {
		this.productRepository = productRepository;
		this.mapper = mapper;
	}

	@Override
	public ProductResponseDto getById(Long id) {
		Product p = productRepository.findById(id)
		.orElseThrow(
				()->
				new NotFoundException("Product not found")
				);
		
		return mapper.toDto(p);
	}

	@Override
	public List<ProductResponseDto> getAll() {
		List<Product> products =
				productRepository.findAll();
		
		return products.stream()
				.map(mapper::toDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public ProductResponseDto getByNameAndPrice(String name, Double price) {
		
		Product p = productRepository.findByNameAndPrice(name, price)
		.orElseThrow(()->new RuntimeException("Product not found"));
		
		return mapper.toDto(p);
	}

	@Override
	public ProductResponseDto getLatest() {
		Product p = productRepository.getLatestProduct();
		return mapper.toDto(p);
	}

	@Override
	public List<ProductResponseDto> searchProduct(String keyword) {
		List<Product> prods = productRepository.searchProductByName(keyword);
		
		return prods.stream()
				.map(mapper::toDto)
				.toList(); 
	}
	
	@Override
	public Page<ProductResponseDto> getProducts(Pageable p) {
		Page<Product> prods = productRepository.findAll(p);
		return prods.map(mapper::toDto);
	}

	@Override
	public ProductResponseDto addProduct(ProductRequestDto dto) {
		
		Product prod = mapper.toEntity(dto);
		Product saved = productRepository.save(prod);
		return mapper.toDto(saved);
	}

	@Override
	public ProductResponseDto updateProduct(Long id,
			ProductRequestDto dto) {
		Product p = productRepository.findById(id)
				.orElseThrow(
						()->
						new RuntimeException("Product not found")
						);
		mapper.map(dto, p);
		
		Product saved = productRepository.save(p);
		
		return mapper.toDto(saved);
	}

	@Override
	public ProductResponseDto updatePrice(Long id,
			UpdatePriceDto dto) {
		Product p = productRepository.findById(id)
				.orElseThrow(
						()->
						new RuntimeException("Product not found")
						);
		
		p.setPrice(dto.getPrice());
		
		Product updated = productRepository.save(p);
		
		return mapper.toDto(updated);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	

	

}

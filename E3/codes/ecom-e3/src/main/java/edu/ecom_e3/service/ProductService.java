package edu.ecom_e3.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.ecom_e3.dto.request.ProductRequestDto;
import edu.ecom_e3.dto.request.UpdatePriceDto;
import edu.ecom_e3.dto.response.ProductResponseDto;

public interface ProductService {
	
	public ProductResponseDto getById(Long id);
	
	public List<ProductResponseDto> getAll();
	
	//---
	
	public ProductResponseDto getByNameAndPrice
	(String name,Double price);
	
	public ProductResponseDto getLatest();
	
	public List<ProductResponseDto> searchProduct(String keyword);
	
	//---
	
	public Page<ProductResponseDto> getProducts(Pageable p);
	
	public ProductResponseDto addProduct(ProductRequestDto dto);
	
	public ProductResponseDto updateProduct(Long id,
			ProductRequestDto dto);
	
	public ProductResponseDto updatePrice(Long id,
			UpdatePriceDto dto);
	
	public void deleteProduct(Long id);
}

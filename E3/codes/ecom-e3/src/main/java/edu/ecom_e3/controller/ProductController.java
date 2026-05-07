package edu.ecom_e3.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ecom_e3.dto.request.ProductRequestDto;
import edu.ecom_e3.dto.request.UpdatePriceDto;
import edu.ecom_e3.dto.response.ApiResponseDto;
import edu.ecom_e3.dto.response.PagedResponseDto;
import edu.ecom_e3.dto.response.ProductResponseDto;
import edu.ecom_e3.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponseDto<ProductResponseDto>> getById(@PathVariable Long id) {
		
		return ResponseEntity.ok(
				ApiResponseDto.success(HttpStatus.OK.value(),
						"Product fetched successfully", 
						productService.getById(id) 
						)
				);
	}
	@GetMapping
	public ResponseEntity<ApiResponseDto<List<ProductResponseDto>>> 
	getAll(){
		return ResponseEntity.ok(
				ApiResponseDto.success(HttpStatus.OK.value(),
						"Products fetched successfully", 
						productService.getAll()
						) 
				);
	}
	
	@GetMapping("/name-and-price")
	public ResponseEntity<ApiResponseDto<ProductResponseDto>> getByNameAndPrice(
			@RequestParam @NotBlank String name,
			@RequestParam @Positive Double price
			) {
		 return ResponseEntity.ok(
					ApiResponseDto.success(HttpStatus.OK.value(),
							"Products fetched successfully", 
							productService.getByNameAndPrice(name, price)
							) 
					);
	}
	
	@GetMapping("/latest")
	public ResponseEntity<ApiResponseDto<ProductResponseDto>> getLatest() {
		 
		 return ResponseEntity.ok(
					ApiResponseDto.success(HttpStatus.OK.value(),
							"Products fetched successfully", 
							productService.getLatest()
							) 
					);
	} 
	
	@GetMapping("/search")
	public ResponseEntity<ApiResponseDto<List<ProductResponseDto>>> 
	search(@RequestParam String keyword){
		
		 return ResponseEntity.ok(
					ApiResponseDto.success(HttpStatus.OK.value(),
							"Products fetched successfully", 
							 productService.searchProduct(keyword)
							) 
					);
	}
	
	@GetMapping("/pagination")
	public ResponseEntity<ApiResponseDto<PagedResponseDto<ProductResponseDto>>>
	getProducts(@ParameterObject Pageable p){
		
		Page<ProductResponseDto> products = productService.getProducts(p);
		
		return ResponseEntity.ok(
				ApiResponseDto.success(200,
						"Products fetched successfully",
						PagedResponseDto.buildPage(products))
				); 
	}
	
	@PostMapping
	public ResponseEntity<ApiResponseDto<ProductResponseDto>> addProduct(
			@RequestBody @Valid ProductRequestDto dto) {
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(
					ApiResponseDto.success(HttpStatus.CREATED.value(),
							"Product added successfully",
							productService.addProduct(dto))
					); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponseDto<ProductResponseDto>> updateProduct(
			@PathVariable Long id,
			@RequestBody @Valid ProductRequestDto dto) {
			
		return ResponseEntity.ok(
				ApiResponseDto.success(HttpStatus.OK.value(),
						"Product updated successfully", 
						productService.updateProduct(id, dto)
						) 
				);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<ApiResponseDto<ProductResponseDto>> updatePrice(
			@PathVariable Long id,
			@RequestBody @Valid UpdatePriceDto dto
			) {
		 
		 return ResponseEntity.ok(
					ApiResponseDto.success(HttpStatus.OK.value(),
							"Price updated successfully", 
							productService.updatePrice(id, dto)
							) 
					);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build(); 
	}
	
}

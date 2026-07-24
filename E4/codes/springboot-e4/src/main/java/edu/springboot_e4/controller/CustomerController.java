package edu.springboot_e4.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import edu.springboot_e4.dto.request.CustomerRequestDto;
import edu.springboot_e4.dto.request.UpdateAgeDto;
import edu.springboot_e4.dto.response.ApiResponseDto;
import edu.springboot_e4.dto.response.CustomerResponseDto;
import edu.springboot_e4.dto.response.PagedResponseDto;
import edu.springboot_e4.service.CustomerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	// handler methods

	// localhost:8080/customers/1
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable long id) {
		return ResponseEntity.ok(
				ApiResponseDto.buildDto(
				"Customer fetched successfully!!",
				HttpStatus.OK.value(),//or 200
				customerService.getCustomerById(id)
				));   
	}

	// localhost:8080/customers 
	@GetMapping
	public ResponseEntity<?> getAllCustomers() {
		return ResponseEntity.ok(
				ApiResponseDto.buildDto(
						"Customers fetched successfully", 
						200,
						customerService.getAllCustomers())
				);
	} 

	@GetMapping("/name-and-age")
	public List<CustomerResponseDto> getByNameAndAge(@RequestParam String name, @RequestParam int age) {
		return customerService.getCustomerByNameAndAge(name, age);
	}

	@GetMapping("/latest")
	public CustomerResponseDto getLatest() {
		return customerService.getLatestCustomer();
	}
	
	@GetMapping("/search")
	public List<CustomerResponseDto> searchCustomer(@RequestParam String keyword) {
		return customerService.searchCustomer(keyword);
	}
	
	
	@GetMapping("/pagination")
	public ResponseEntity<?> getCustomers(@ParameterObject Pageable p){
		Page<CustomerResponseDto> customers = customerService.getCustomers(p);
		
		return ResponseEntity.ok(
				PagedResponseDto.buildPagedDto(customers)
				);
	} 
	

	@PostMapping
	public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerRequestDto dto) {
		
		ApiResponseDto<CustomerResponseDto> respDto = 
				ApiResponseDto.buildDto
		("Customer inserted successfully",
				201,
				customerService.saveCustomer(dto));
		
		return ResponseEntity.status(201)
				.body(respDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable long id, @RequestBody CustomerRequestDto dto) {
		return ResponseEntity.ok(
				
				ApiResponseDto.buildDto("Updated successfully",
						200, 
						customerService.updateCustomer(id, dto))
				);
	}

	@PatchMapping("/{id}")
	public CustomerResponseDto updateCustomerAge(@PathVariable long id, @Valid @RequestBody UpdateAgeDto dto) {
		return customerService.updateCustomerAge(id, dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.noContent().build(); 
	}
}

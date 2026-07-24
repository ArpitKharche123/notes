package edu.springboot_e4.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.springboot_e4.dto.request.CustomerRequestDto;
import edu.springboot_e4.dto.request.UpdateAgeDto;
import edu.springboot_e4.dto.response.CustomerResponseDto;

public interface CustomerService {
	//Business Logic Plan
	
	public CustomerResponseDto getCustomerById(long id);
	
	public List<CustomerResponseDto> getAllCustomers();
	
	public List<CustomerResponseDto> getCustomerByNameAndAge(String name, int age);
	
	public CustomerResponseDto getLatestCustomer();
	
	public List<CustomerResponseDto> searchCustomer(String keyword);
	
	public Page<CustomerResponseDto> getCustomers(Pageable p);
	
	public CustomerResponseDto saveCustomer(
			CustomerRequestDto requestDto);
	
	public CustomerResponseDto updateCustomer(
			long id, CustomerRequestDto requestDto);
	
	public CustomerResponseDto updateCustomerAge(
			long id,UpdateAgeDto ageDto);
	
	public void deleteCustomer(long id);
	
	
}

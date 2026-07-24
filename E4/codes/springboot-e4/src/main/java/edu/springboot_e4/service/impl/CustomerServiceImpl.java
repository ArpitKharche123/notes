package edu.springboot_e4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.springboot_e4.dto.request.CustomerRequestDto;
import edu.springboot_e4.dto.request.UpdateAgeDto;
import edu.springboot_e4.dto.response.CustomerResponseDto;
import edu.springboot_e4.entity.Customer;
import edu.springboot_e4.exception.CustomerNotFoundException;
import edu.springboot_e4.mapper.CustomerMapper;
import edu.springboot_e4.repository.CustomerRepository;
import edu.springboot_e4.service.CustomerService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	private CustomerMapper mapper;
	
	//Business Logic implementation
	@Override
	public CustomerResponseDto getCustomerById(long id) {
		Customer customer = customerRepository.findById(id)
		.orElseThrow(()->
		new CustomerNotFoundException("Customer not found with given id"));
		
		return mapper.toDto(customer);
	}

	@Override
	public List<CustomerResponseDto> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream()
				        .map(mapper::toDto)
				        .toList();
	}
	
	@Override
	public List<CustomerResponseDto> getCustomerByNameAndAge(
			String name, int age) {
		
		List<Customer> customers = 
				customerRepository.findByNameAndAge(name, age);
		
		return customers.stream()
				.map(mapper::toDto)
				.toList();
	}

	@Override
	public CustomerResponseDto getLatestCustomer() {
		
		Customer customer = customerRepository.findLatestCustomer()
		.orElseThrow(()->new RuntimeException("Customer not present!"));
		
		return mapper.toDto(customer);
	}
	
	@Override
	public List<CustomerResponseDto> searchCustomer(String keyword) {
		
		List<Customer> customers = customerRepository.searchCustomer(keyword);
		
		return customers.stream()
				.map(mapper::toDto)
				.toList();
	}
	
	@Override
	public Page<CustomerResponseDto> getCustomers(Pageable p) {
		Page<Customer> page = customerRepository.findAll(p);
		return page.map(mapper::toDto);
	}

	
	@Override
	public CustomerResponseDto saveCustomer(CustomerRequestDto requestDto) {
		Customer customer = mapper.toEntity(requestDto);
		
		Customer savedCustomer = customerRepository.save(customer);
		
		return mapper.toDto(savedCustomer);
	}

	@Override
	public CustomerResponseDto updateCustomer(long id, CustomerRequestDto requestDto) {
		Customer customer = customerRepository.findById(id)
		.orElseThrow(()->new RuntimeException("Customer not found!"));
		
		//Updating the existing customer
		mapper.map(requestDto, customer);
		
		Customer updatedCustomer = customerRepository.save(customer);
		
		return mapper.toDto(updatedCustomer);
	}

	@Override
	public CustomerResponseDto updateCustomerAge(long id,
			UpdateAgeDto ageDto) {
		Customer customer = customerRepository.findById(id)
		.orElseThrow(()->new RuntimeException("Customer not found!"));
		
		customer.setAge(ageDto.getAge());
		
		Customer updatedCustomer = customerRepository.save(customer);
		
		return mapper.toDto(updatedCustomer);
	}

	@Override
	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}
}

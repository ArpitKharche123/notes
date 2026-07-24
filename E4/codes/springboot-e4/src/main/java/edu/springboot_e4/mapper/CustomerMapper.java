package edu.springboot_e4.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.springboot_e4.dto.request.CustomerRequestDto;
import edu.springboot_e4.dto.response.CustomerResponseDto;
import edu.springboot_e4.entity.Customer;

@Component
public class CustomerMapper {
	@Autowired
	private ModelMapper mapper;
	
	public CustomerResponseDto toDto(Customer customer){
		return mapper.map(customer, CustomerResponseDto.class);
	}
	
	public Customer toEntity(CustomerRequestDto requestDto){
		return mapper.map(requestDto, Customer.class);
	}
	
	public void map(CustomerRequestDto dto, Customer c) {
		mapper.map(dto, c);
	}
}

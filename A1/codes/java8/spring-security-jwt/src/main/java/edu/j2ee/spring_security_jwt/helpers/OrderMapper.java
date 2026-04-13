package edu.j2ee.spring_security_jwt.helpers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import edu.j2ee.spring_security_jwt.dto.UserDto;
import edu.j2ee.spring_security_jwt.dto.response.OrderResponseDto;
import edu.j2ee.spring_security_jwt.dto.response.ProductResponseDto;
import edu.j2ee.spring_security_jwt.entities.Order;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderMapper {
//@formatter:off
	private final ModelMapper mapper;
	
    public OrderResponseDto toDto(Order order) {
    	
    	//User to userDto
    	UserDto userDto= mapper.map(order.getUser(), UserDto.class);
    	
    	//list of products to list of ProductResponseDto
    	List<ProductResponseDto> products= order.getProducts()
    			.stream()
    			.map(p-> 
    				mapper.map(p, ProductResponseDto.class))
    			.toList();
    
    	OrderResponseDto dto = new OrderResponseDto();
    	dto.setId(order.getId());
    	dto.setUser(userDto);
    	dto.setProducts(products);
    	
    	return dto;
    }
}

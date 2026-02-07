package edu.j2ee.spring_security_jwt.services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import edu.j2ee.spring_security_jwt.dto.request.OrderRequestDto;
import edu.j2ee.spring_security_jwt.dto.response.OrderResponseDto;
import edu.j2ee.spring_security_jwt.entities.Order;
import edu.j2ee.spring_security_jwt.entities.Product;
import edu.j2ee.spring_security_jwt.entities.User;
import edu.j2ee.spring_security_jwt.helpers.OrderMapper;
import edu.j2ee.spring_security_jwt.repositories.OrderRepository;
import edu.j2ee.spring_security_jwt.repositories.ProductRepository;
import edu.j2ee.spring_security_jwt.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;
	private final OrderMapper orderMapper;

	public OrderResponseDto placeOrder(OrderRequestDto requestDto, Authentication authentication) {

		// Get user name from JWT token
		String username = authentication.getName();

		// Fetch User entity
		User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

		// Fetch Products by IDs
		List<Product> products = productRepository.findAllById(requestDto.getProductIds());

		if (products.isEmpty()) {
			throw new RuntimeException("No products found");
		}

		// Create Order entity
		Order order = new Order();
		order.setUser(user);
		order.setProducts(products);

		// Save order
		Order savedOrder = orderRepository.save(order);

		return orderMapper.toDto(savedOrder);
	}

	public Order getOrder(Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
	}

}

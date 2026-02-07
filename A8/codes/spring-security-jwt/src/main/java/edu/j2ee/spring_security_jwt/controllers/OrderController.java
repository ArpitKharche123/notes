package edu.j2ee.spring_security_jwt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.j2ee.spring_security_jwt.dto.request.OrderRequestDto;
import edu.j2ee.spring_security_jwt.dto.response.OrderResponseDto;
import edu.j2ee.spring_security_jwt.repositories.OrderRepository;
import edu.j2ee.spring_security_jwt.repositories.UserRepository;
import edu.j2ee.spring_security_jwt.services.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderRequestDto requestDto,
			Authentication authentication) {

		OrderResponseDto response = orderService.placeOrder(requestDto, authentication);

		return ResponseEntity.ok(response);
	}
}

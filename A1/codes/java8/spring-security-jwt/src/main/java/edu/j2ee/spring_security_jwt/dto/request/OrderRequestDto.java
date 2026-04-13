package edu.j2ee.spring_security_jwt.dto.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
	private List<Long> productIds;
}

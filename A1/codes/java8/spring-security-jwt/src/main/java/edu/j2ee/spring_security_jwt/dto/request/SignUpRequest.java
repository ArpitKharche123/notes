package edu.j2ee.spring_security_jwt.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
	private String username;
	private String password;
}

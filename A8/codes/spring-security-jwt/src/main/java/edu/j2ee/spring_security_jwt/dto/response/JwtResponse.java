package edu.j2ee.spring_security_jwt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
public class JwtResponse {
    private String token;
}
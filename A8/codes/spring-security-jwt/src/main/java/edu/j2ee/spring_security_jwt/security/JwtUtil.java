package edu.j2ee.spring_security_jwt.security;

import java.time.Duration;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class JwtUtil {
//@formatter:off
	
	// Secret key for signing JWT
	@Value("${security.secret-key}")
    private String SECRET_KEY;
	
	//  Token expiry time
	@Value("${security.exp-time}")
    private Duration expTime;

	//JWT Token generation for the given Username
	
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expTime.toMillis()))
                // Sign token using secret key encoded with  HMAC-SHA algorithm
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .compact();
    }

    //Extracting username form token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
               // Validate and parse token
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}

package edu.j2ee.spring_security_jwt.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.j2ee.spring_security_jwt.dto.request.LoginRequest;
import edu.j2ee.spring_security_jwt.dto.request.SignUpRequest;
import edu.j2ee.spring_security_jwt.dto.response.JwtResponse;
import edu.j2ee.spring_security_jwt.entities.User;
import edu.j2ee.spring_security_jwt.repositories.UserRepository;
import edu.j2ee.spring_security_jwt.security.JwtUtil;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
//@formatter:off
	
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    // SIGNUP API
    @PostMapping("/signup")
    public String signup(@RequestBody SignUpRequest request) {
    	
    	
    	User user = new User();
    		user.setUsername(request.getUsername());
    		user.setPassword(passwordEncoder.encode(request.getPassword()));
    		user.setRole("ROLE_USER");

        userRepository.save(user);
        return "User registered successfully";
    }

    // LOGIN API
    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
    	
    	// Authenticating username and password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword())
        );
        
        //If authenticated, Generate JWT token and return it
        String token = jwtUtil.generateToken(request.getUsername());
        return new JwtResponse(token);
    }
}

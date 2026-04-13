package edu.j2ee.spring_security_jwt.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

//Runs before every request.
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

	// Utility to handle JWT operations
	private final JwtUtil jwtUtil;
	
	// Service to load user details
	private final CustomUserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		//Reads Authorization Header
		String authHeader = request.getHeader("Authorization");

		// Check if header is present and starts with Bearer
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			
			//Extract token
			String token = authHeader.substring(7);
			
			//Extract username
			String username = jwtUtil.extractUsername(token);

			// Check whether the user is not already authenticated
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				
				// Load user details from DB
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				
				// Create authentication object
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());
				
				// Storing authentication details in security context
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
		//Continue request chain(repeat filter chain process for next Request)
		filterChain.doFilter(request, response);
	}
}

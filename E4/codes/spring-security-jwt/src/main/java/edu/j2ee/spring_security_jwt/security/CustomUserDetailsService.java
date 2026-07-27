package edu.j2ee.spring_security_jwt.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.j2ee.spring_security_jwt.entities.User;
import edu.j2ee.spring_security_jwt.repositories.UserRepository;

//Used by Spring Security to load user details
@Service
public class CustomUserDetailsService implements UserDetailsService {
//@formatter:off
	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	//Automatically called during authentication process
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		// Converting In DB User entity into Spring Security User object
		return org.springframework.security.core.userdetails.User
				.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole()
				.replace("ROLE_", ""))
				.build();
	}
}

package edu.j2ee.spring_security_jwt.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class AppConfig {
//@formatter:off
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
	//PaswordEncode Bean
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Swagger(OpenAi bean) config with Spring Security
	 @Bean
	    public OpenAPI openAPI() {

	        return new OpenAPI()
	            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
	            .components(new Components()
	                .addSecuritySchemes("bearerAuth",
	                    new SecurityScheme()
	                        .name("Authorization")
	                        .type(SecurityScheme.Type.HTTP)
	                        .scheme("bearer")
	                        .bearerFormat("JWT")
	                )
	            );
	    }
}

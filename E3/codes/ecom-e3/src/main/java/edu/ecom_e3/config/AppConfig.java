package edu.ecom_e3.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	ModelMapper getMapper() {
		return new ModelMapper();
	}
}

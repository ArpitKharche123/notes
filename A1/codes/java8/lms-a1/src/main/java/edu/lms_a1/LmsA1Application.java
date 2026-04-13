package edu.lms_a1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LmsA1Application {
	//localhost:8080/swagger-ui.html
	public static void main(String[] args) {
		SpringApplication.run(LmsA1Application.class, args);
	}

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
}

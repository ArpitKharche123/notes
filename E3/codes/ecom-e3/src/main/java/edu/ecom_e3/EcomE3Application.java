package edu.ecom_e3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EcomE3Application {
	//http://localhost:8080/swagger-ui.html
	public static void main(String[] args) {
		SpringApplication.run(EcomE3Application.class, args);
	}

}

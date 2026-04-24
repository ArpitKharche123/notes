package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@Getter
//This annotation will create an constructor
//for all the final fields/properties
@RequiredArgsConstructor
@PropertySource("classpath:demo.properties")
public class Car {
	
	private final Engine engine;

	//Constructor Injection
//	public Car(Engine engine) {
//		this.engine = engine;
//	}
	
	//Setter Injection -optional dependencies
	@Setter
	private Person person;
	
	//Field Injection
	@Autowired
	private MusicSystem system;
	
	@Value("BMW")
	private String model;
	
	@Value("${car.id}")
	private String carID;
}

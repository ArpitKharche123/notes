package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
//Creates a Constructor for final fields
@RequiredArgsConstructor
@Getter
@PropertySource("classpath:car.properties")
public class Car {
	
	private final Engine engine;


	//1. Constructor Injection
//	public Car(Engine engine) {
//		this.engine = engine;
//	}
	
	//2. Setter Injection
	@Setter
	private Person person;
	
	//3. Field Injection
	@Autowired
	private FuelTank tank;
	
	@Value("base")
	private String model;
	
	@Value("${car.id}")
	private String carID;
}

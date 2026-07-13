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
@PropertySource("classpath:app.properties")
@RequiredArgsConstructor //creates constructor for final fields
public class Car {
	private final Engine engine;

	//Constructor Injection(most recommended)
//	public Car(Engine engine) {
//		this.engine = engine;
//	}
	
	//Setter Injection
	@Setter
	private Person person;
	
	//Field Injection
	@Autowired
	private MusicSystem musicSystem;
	
	
	//Value injection
	@Value("${car.regno}")
	private long regNo;
}

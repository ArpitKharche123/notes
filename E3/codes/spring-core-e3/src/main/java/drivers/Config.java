package drivers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import beans.Demo;

@Configuration
@ComponentScan("beans")
public class Config {
	
	@Bean
	// Bean Scopes
	//Singleton -1 object
	//Prototype -n objects
	
	@Scope("prototype")
	public Demo beanMethod() {
		return new Demo();
	}
}

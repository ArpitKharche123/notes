package drivers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import beans.Test;

@Configuration
@ComponentScan(basePackages = "beans")
public class Config {
	//factory method
	@Bean
	@Scope("prototype")//new beans will get created everytime
					   // it is requested
	public Test getTest() {
		return new Test();
	}
	/*
	 * Bean Scopes
	 *  
	 *  -singleton (default)
	 *  -prototype
	 */
}

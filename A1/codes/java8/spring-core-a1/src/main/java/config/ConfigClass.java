package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import beans.Engine;

@Configuration
@ComponentScan("beans")
public class ConfigClass {

	@Bean // Indicates that a method will
	// create an object/bean and will be managed
	// by Spring Container

	// Bean Scopes:
	// 1. singleton(default):
	// Only one bean/object for one JavaBean Class
	// 2. prototype:
	// Multiple Objects/Beans will be created
	@Scope("prototype")
	public Engine getEngine() {
		return new Engine();
	}
}

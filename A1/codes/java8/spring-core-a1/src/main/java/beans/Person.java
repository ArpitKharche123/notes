package beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component //Declares the class as a Bean class
//It makes the class eligible for the bean
//management done by Spring container
@Scope("prototype")
@Getter
@Setter
public class Person {
	private String name = "Smith";
}

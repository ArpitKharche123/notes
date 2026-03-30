package drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Engine;
import beans.Person;
import config.ConfigClass;

public class TestIOC {
	public static void main(String[] args) {
		
		ApplicationContext context
		= new AnnotationConfigApplicationContext
		(ConfigClass.class);
		
		Person p = context.getBean(Person.class);
		System.out.println(p.getName());
		
		Engine e= context.getBean(Engine.class),
			 e2= context.getBean(Engine.class);
		
		//Both will be different if 
		//Bean Scope is Prototype
		System.out.println(e);
		System.out.println(e2);
	}
}

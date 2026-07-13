package drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Demo;
import beans.Test;

public class TestIOC {
	public static void main(String[] args) {
		ApplicationContext context=
		new AnnotationConfigApplicationContext(Config.class);
		
		Demo d = context.getBean(Demo.class);
		System.out.println(d);
		
		Test t = context.getBean(Test.class);
		System.out.println(t);
		
		Test t2= context.getBean(Test.class);
		
		System.out.println(t==t2);
		//true if scope is singleton
		//false if scope is prototype
	
	}
}

package drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Bag;

public class Demo {
	public static void main(String[] args) {
		ApplicationContext context
			= new AnnotationConfigApplicationContext(Config.class);
		
		Bag bag = context.getBean(Bag.class);
		
		System.out.println(bag.getBottle());
	}
}

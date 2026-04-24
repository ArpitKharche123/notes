package drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Bag;
import beans.Car;
import beans.Person;

public class TestDI {
	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(
				Config.class);
		
		Car car=context.getBean(Car.class);
		System.out.println(car.getEngine());
		
		
		Person p=context.getBean(Person.class);
		car.setPerson(p);//setter injection
		System.out.println(car.getPerson());
		
		System.out.println(car.getSystem());
		System.out.println(car.getModel());
		System.out.println(car.getCarID());
		
		Bag b=context.getBean(Bag.class);
		b.getBottle().drink();
		
	}
}

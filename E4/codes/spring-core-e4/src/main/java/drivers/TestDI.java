package drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Car;
import beans.Person;

public class TestDI {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		Car car = context.getBean(Car.class);
		System.out.println(car.getEngine());

		System.out.println(car.getPerson());// null

		Person p = context.getBean(Person.class);
		car.setPerson(p);
		System.out.println(car.getPerson());

		System.out.println(car.getMusicSystem());

		System.out.println(car.getRegNo());

	}
}

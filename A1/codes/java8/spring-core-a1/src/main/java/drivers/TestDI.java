package drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Car;
import beans.Compass;
import beans.Person;
import config.ConfigClass;

public class TestDI {
	public static void main(String[] args) {
		ApplicationContext c = new AnnotationConfigApplicationContext(ConfigClass.class);

		Car car = c.getBean(Car.class);
		System.out.println(car.getEngine());
		
		car.setPerson(c.getBean(Person.class));
		System.out.println(car.getPerson());
		
		System.out.println(car.getTank());
		System.out.println(car.getModel());
		
		System.out.println(car.getCarID());
		
		Compass compass=c.getBean(Compass.class);
		compass.getRuler().measure();
	}
}

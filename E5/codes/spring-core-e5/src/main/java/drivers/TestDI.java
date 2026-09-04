package drivers;

import beans.Car;
import beans.Person;
import beans2.Bag;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDI {
    static void main() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Car car = context.getBean(Car.class);
        System.out.println(car.getEngine());

        System.out.println(car.getPerson());//null

        Person p = context.getBean(Person.class);
        car.setPerson(p);//setter injection

        System.out.println(car.getPerson());

        System.out.println(car.getDriver());
        System.out.println(car.getRegNo());

        Bag b = context.getBean(Bag.class);
        System.out.println(b.getBottle());
    }
    /*
        class Bag
          has-a
       interface Bottle
             |
       class SteelBottle
     */
}

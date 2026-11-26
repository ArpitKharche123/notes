package drivers;

import beans.Car;
import beans.Driver;
import beans.Engine;
import beans.Person;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDependencyInjection {
    static void main() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext
                (AppConfig.class);

        //1. Constructor Injection
        Car car = context.getBean(Car.class);
        Engine engine = car.getEngine();

        System.out.println(engine);

        //2. Setter Injection
        Person person = car.getPerson();
        System.out.println(person); //null
        // o/p: reference if @Autowired is used!

        person = context.getBean(Person.class);
        car.setPerson(person);

        System.out.println(car.getPerson());

        //3. Field Injection
        Driver driver = car.getDriver();
        System.out.println(driver);

        System.out.println(car.getNumber());
    }
}

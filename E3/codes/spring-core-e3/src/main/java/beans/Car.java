package beans;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Getter
@PropertySource("classpath:app.properties")
public class Car {
    private Engine engine;
//    @Setter
    private Person person;

    //1. Constructor Injection(most recommended)
    @Autowired
    /*
    optional, used when class is having multiple constructors
     */
    public Car(Engine engine) {
        this.engine = engine;
    }
    public Car(){}

  //  2. Setter Injection
    @Autowired
    //Dependency injection will occur automatically
    //if @Autowired is used
    public void setPerson(Person person) {
        this.person = person;
    }

    //3. Field Injection
    @Autowired
    private Driver driver;

    @Value("${car.no}")
    private String number;
}

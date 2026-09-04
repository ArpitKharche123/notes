package beans;

import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("classpath:app.properties")
public class Car {
    Engine engine;

    //Constructor Injection
    public Car(Engine engine) {
        this.engine = engine;
    }

    //Setter Injection
    //Dependency Injection will not happen unless we call the setter!!!

    //@Setter
    private Person person;
    //or
    public void setPerson(Person person) {
        this.person = person;
    }

    //Field injection
    @Autowired
    private Driver driver;

    @Value("${car.regno}")
    private Long regNo;

}

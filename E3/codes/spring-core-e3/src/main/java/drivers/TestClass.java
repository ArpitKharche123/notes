package drivers;

import beans2.Bag;
import beans2.Bottle;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClass {
    static void main() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext
                (AppConfig.class);

        Bag bag = context.getBean(Bag.class);
        Bottle bottle = bag.getBottle();
        bottle.print();
    }
}

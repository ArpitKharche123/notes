package drivers;

import beans.Demo;
import beans.Test;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestIOC {
    static void main() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext
                (AppConfig.class);

        Demo d = context.getBean(Demo.class);
        Demo d2 = context.getBean(Demo.class);
        System.out.println(d == d2);//true (singleton)

        Test t = context.getBean(Test.class);
        Test t2 = context.getBean(Test.class);
        System.out.println(t == t2);//false (prototype)

//        System.out.println(t);
    }
}
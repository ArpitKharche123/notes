package drivers;

import beans.MyBeanClass;
import beans.Test;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestIOC {
    static void main() {
        ApplicationContext context =
       new AnnotationConfigApplicationContext(AppConfig.class);

        MyBeanClass bean = context.getBean(MyBeanClass.class);

        System.out.println(bean);

        Test t = context.getBean(Test.class);
        System.out.println(t);

        Test t2 = context.getBean(Test.class);
        System.out.println(t==t2);
        //true (singleton scope)
        //false (prototype scope)

    }
}

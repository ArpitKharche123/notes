package drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.BeanClass;
import beans.Demo;
public class TestIOC {
	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(
				Config.class);
		
		BeanClass bean = context.getBean(BeanClass.class);
		System.out.println(bean);
		bean.m();
		
		Demo d = context.getBean(Demo.class),
			d2 = context.getBean(Demo.class);
		
		System.out.println(d+"\n"+d2);
		
		//d.demo();

	}
}

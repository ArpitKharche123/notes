package beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BeanClass {
	public void m() {
		System.out.println("method of BeanClass");
	}
}
//Bean -> bean
//BEAN -> BEAN
//BeanClass ->beanClass
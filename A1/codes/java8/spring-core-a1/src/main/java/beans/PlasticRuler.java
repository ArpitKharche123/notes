package beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //PlasticRuler bean will be injected
//in Compass
public class PlasticRuler implements Ruler{
	@Override
	public void measure() {
		System.out.println(
			"Measuring by plastic ruler");
	}
}

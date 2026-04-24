package beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SteelBottle implements Bottle {
	@Override
	public void drink() {
		System.out.println("Drinking by Steel Bottle");
	}
}

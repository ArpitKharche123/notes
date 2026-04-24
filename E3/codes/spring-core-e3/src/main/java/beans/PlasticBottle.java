package beans;

import org.springframework.stereotype.Component;

@Component
public class PlasticBottle implements Bottle {
	@Override
	public void drink() {
		System.out.println("Drinking with plastic bottle");
	}
}

package beans;

import org.springframework.stereotype.Component;

@Component("steel")
public class SteelRuler implements Ruler{
	@Override
	public void measure() {
		System.out.println(
		"Measuring by steel ruler");
	}
}

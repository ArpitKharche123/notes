package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class Bag {
	@Autowired
	@Qualifier("plasticBottle")
	private Bottle bottle;
}

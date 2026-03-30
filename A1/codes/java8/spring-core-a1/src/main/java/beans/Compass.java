package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Compass {
	@Autowired
	//@Qualifier("steel") 
	//Bean will be created for SteelRuler Class
	private Ruler ruler;
}

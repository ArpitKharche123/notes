package beans2;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Getter
//@AllArgsConstructor
public class Bag {
    @Autowired
    @Qualifier("steelBottle")
    private Bottle bottle;
}

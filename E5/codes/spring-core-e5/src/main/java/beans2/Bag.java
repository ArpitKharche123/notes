package beans2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Data
//@AllArgsConstructor //creates constructor for all the fields
//@RequiredArgsConstructor  //creates constructor for final fields
public class Bag {
    @Autowired
    @Qualifier("steelBottle")
    private final Bottle bottle;
}

package inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue(value = "PART_TIME")
@Data
public class PartTimeEmployee extends Employee {
	private int durationInMonths;
	private double fixedPay;
}

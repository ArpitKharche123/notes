package inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue(value = "PART_TIME")
public class PartTimeEmployee extends Employee {
	private int hours;
	private int months;
	private double pay;
}

package inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue(value = "FULL_TIME")
@Data
public class FullTimeEmployee extends Employee {
	private double salary;
	private double exp;
}

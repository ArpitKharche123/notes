package inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue(value = "FULL_TIME")
public class FullTimeEmployee extends Employee {
	private double salary;
	private int exp;
}

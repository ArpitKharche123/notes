package entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue(value = "FULL_TIME")
public class FullTimeEmployee extends Emp {
	
	private String salary;
	private int yearOfExp;
	private double bonus;
}

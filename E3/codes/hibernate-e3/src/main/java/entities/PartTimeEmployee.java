package entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue(value = "PART_TIME")
public class PartTimeEmployee extends Emp {
	private int durationInMonths;
	private double pay;
}

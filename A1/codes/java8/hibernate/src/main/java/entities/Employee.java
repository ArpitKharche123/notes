package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "emp_seq")
	@SequenceGenerator(
			name = "emp_seq",
			initialValue = 1,//starting value
			allocationSize = 1)//incrementing by
	private long id;
	
	private String name;
	
}

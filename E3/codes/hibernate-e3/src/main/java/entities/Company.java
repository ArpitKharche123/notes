package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "company_seq")
	@SequenceGenerator(
			name = "company_seq",
			initialValue = 1,
			allocationSize = 1
			)
	private long id;
	private String name;
	private String address;
}	

package one_to_many_to_one.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Department {
	@Id
	@GeneratedValue(strategy 
			= GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "dept",cascade =
		CascadeType.PERSIST)
	@ToString.Exclude
	private List<Employee2> employees;
}

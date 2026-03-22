package otm.entities;

import java.util.List;

import org.hibernate.jdbc.Expectation.None;

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
public class Bank {
	@Id
	@GeneratedValue(strategy 
			= GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	
	@OneToMany
	@ToString.Exclude
	private List<Account> accounts;
}

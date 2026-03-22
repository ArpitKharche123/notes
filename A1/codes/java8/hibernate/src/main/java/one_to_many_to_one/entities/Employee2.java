package one_to_many_to_one.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Employee2 {
	@Id
	@GeneratedValue(strategy 
			= GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String bloodGroup;
	
	@ManyToOne
	@JoinColumn
	@ToString.Exclude
	private Department dept;
}

package m2m.bi.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@ManyToMany
	@JoinTable(
			name = "trainer_subject",
			joinColumns = 
			@JoinColumn(name="trainer_id"),
			inverseJoinColumns = 
			@JoinColumn(name="subject_id")
			)
	private List<Subject2> subjects;
}

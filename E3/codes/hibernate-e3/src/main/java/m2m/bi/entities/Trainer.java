package m2m.bi.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private long phone;
	
	@ManyToMany
	@JoinTable(
			name = "trainers_subjects",
			joinColumns = 
			@JoinColumn(name = "trainer_id"),
			inverseJoinColumns =
			@JoinColumn(name = "subject_id")
			)
	private List<Subject> subjects;
}

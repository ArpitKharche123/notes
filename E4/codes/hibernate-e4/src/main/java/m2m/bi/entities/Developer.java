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
public class Developer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double exp;
	private String role;
	
	@ManyToMany
	@JoinTable(name = "dev_lang",
	joinColumns = @JoinColumn(name="dev_id"),
	inverseJoinColumns = @JoinColumn(name="lang_id")
	)
	private List<Language> languages;
}

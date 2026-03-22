package otm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Account {
	@Id
	@GeneratedValue(strategy 
			= GenerationType.IDENTITY)
	private long id;
	private String holderName;
	
	@Column(unique = true)
	private long accountNumber;
	private String type;
	
	
	
}

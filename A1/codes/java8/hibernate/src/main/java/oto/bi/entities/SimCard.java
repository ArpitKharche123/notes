package oto.bi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SimCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String company;
	private String networkType;
	
	@OneToOne(mappedBy = "sim")
	private Mobile mobile;

	@Override
	public String toString() {
		return "SimCard [id=" + id + ", company=" + company + ", networkType=" + networkType + 
				 "]";
	}
	
	
	
}

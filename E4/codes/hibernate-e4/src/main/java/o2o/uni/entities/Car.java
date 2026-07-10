package o2o.uni.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String brand;
	private String color;
	private double price;
	
	/*
	 * Fetch Types: EAGER, LAZY

		one-to-one , many-to-one:  EAGER
		one-to-many, many-to-many: LAZY
	 */
	@OneToOne(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
			orphanRemoval = true)
	private Engine engine;
}

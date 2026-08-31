package oto.uni.entities;

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
	private int id;
	
	private String brand;
	private String color;
	private double price;
	
	/*
	 * Fetch Types
	 *
	 *  EAGER 
	 *  - Child Entity Object will also get fetched automatically
	 *   when Parent Entity Object is fetched
	 *   
	 *  default for - OneToOne , ManyToOne
	 *  
	 *  
	 *  LAZY  
	 *  - Child Entity Object will not get fetched automatically
	 *   when Parent Entity Object is fetched
	 *   
	 *  default for- OneToMany , ManyToMany
	 */
	@OneToOne(fetch = FetchType.LAZY,
			cascade = {
					//persisting parent entity will also persist
					//child entity
					CascadeType.PERSIST, 
					
					//Removing parent entity will aslo remove
					//child entity
					CascadeType.REMOVE},
			//After breaking the association with Parent Entity,
			//Child Entity will get deleted
			orphanRemoval = true
			)
	private Engine engine;
}

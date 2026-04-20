package oto.uni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String brand;
	private String color;
	private double price;
	
	@OneToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	private Engine engine;
	/*
	 * fetch types
	 * 
	 * EAGER - OneToOne, ManyToOne
	 * LAZY  - OneToMany, ManyToMany
	 */
}

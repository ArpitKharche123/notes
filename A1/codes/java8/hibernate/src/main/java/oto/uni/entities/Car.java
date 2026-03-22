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
@Setter
@Getter
@ToString
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String brand;
	private String color;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Engine engine;
	/*
	 * Fetch types:
	 * 
	 * EAGER -OneToOne, ManyToOne
	 * LAZY - OneToMany, ManyToMany
	 */
}

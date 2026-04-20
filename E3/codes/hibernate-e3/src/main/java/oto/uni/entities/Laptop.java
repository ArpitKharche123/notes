package oto.uni.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String model;
	private String brand;
	private double price;
	
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
	,orphanRemoval = true)
	private Charger charger;
}

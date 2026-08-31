package oto.bi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String model;
	private String brand;
	private double price;
	
	@OneToOne
	@JoinColumn //foreign key column will be present here
	private Battery battery;

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", model=" + model + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
}

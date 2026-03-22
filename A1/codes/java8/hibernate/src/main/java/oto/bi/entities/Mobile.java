package oto.bi.entities;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Mobile {
	@Id
	@GeneratedValue(strategy
			= GenerationType.IDENTITY)
	private long id;
	
	private String brand;
	private String color;
	private double price;
	
	@OneToOne
	@JoinColumn
	private SimCard sim;

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", brand=" + brand + ", color=" + color + ", price=" + price + "]";
	}
	
	
}

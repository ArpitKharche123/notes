package oto.uni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Engine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double cc;
	private String type;
}

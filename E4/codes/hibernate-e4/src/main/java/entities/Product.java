package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "id_gen")
	@SequenceGenerator(
			name = "id_gen",
			initialValue = 1000,//intial id/first id
			allocationSize = 1//by how much it will increase
			)
	private long id;
	private String name;
	private double price;
}

		/*
		 
		  Hibernate mapping
		  
		  e.g: Car has a Engine
		  
		  *Based on direction:
		  
		  uni-directional   Car has a Engine
		  bi-directional    Car has a Engine, Engine has a Car
		  
		  *Based on no. of Objects
		  
		  One-To-One
		  One-To-Many
		  Many-To-One
		  Many-To-Many
		  
		  
		  src/main
		  	   |
		      o2o
		         - uni
		            -driver
		            -entities
		         - bi
		            -driver
		            -entities
		 
		 */

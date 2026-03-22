package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity //marks the class a Entity Class
//Hibernate will create a table for this class

//@Table(name = "student_details")

@Getter
@Setter
@ToString
public class Student {
	@Id //Primary Key
	@GeneratedValue(
			strategy = GenerationType.IDENTITY)
	//Auto increment by 1, starting from 1
	private int id;
	
	@Column(name = "s_name",nullable = false)
	private String name;
	
	private String standard;
	private char section;
	
	@Column(unique = true)
	private String email;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDate updatedAt;
	
	
}

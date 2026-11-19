package m2o.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "patients")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private double weight;
    @ManyToOne
    private Hospital hospital;
}

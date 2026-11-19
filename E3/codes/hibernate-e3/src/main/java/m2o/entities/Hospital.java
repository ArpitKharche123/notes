package m2o.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hospitals")
@Data
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private String location;
}

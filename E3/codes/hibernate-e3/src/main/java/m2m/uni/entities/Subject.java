package m2m.uni.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "subjects")
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int credits;
}

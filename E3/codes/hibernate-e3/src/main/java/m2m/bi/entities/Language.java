package m2m.bi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "languages")
@Data
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double version;
    private String type;

    @ManyToMany(mappedBy = "languages")
    List<Developer> developers;
}

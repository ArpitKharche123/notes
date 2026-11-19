package m2m.bi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "developers")
@Data
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String role;
    private int exp;

    @ManyToMany
    @JoinTable(
     name = "developer_language",
     joinColumns = @JoinColumn(name = "developer_id"),
     inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    List<Language> languages;
}

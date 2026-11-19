package o2m_bi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;

    private double price;
    @ManyToOne
    @JoinColumn
    private Library library;
}

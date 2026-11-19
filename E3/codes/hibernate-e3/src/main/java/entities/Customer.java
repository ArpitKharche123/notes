package entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity //Marks the class as an Entity Class
@Table(name = "customers")
//Lombok Annotations
@Getter
@Setter
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Customer {
    @Id //Specifies primary key of an Entity
    //Automatic key generation strategy
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_name",nullable = false)
    private String name;

    private int age;

    @Column(nullable = false,unique = true)
    private String email;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

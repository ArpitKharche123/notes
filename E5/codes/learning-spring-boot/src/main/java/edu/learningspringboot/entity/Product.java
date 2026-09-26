package edu.learningspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products",indexes = {
        @Index(name = "idx_product_name",columnList = "name"),
        @Index(name = "idx_product_category",columnList = "category")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 50)
    private String name;

    @Column(nullable = false,length = 50)
    private String category;

    @Column(precision = 10,scale = 2, nullable = false)
    private BigDecimal price;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private Instant createdAt;
}

package o2o.uni.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String model;
    private String brand;
    private String color;
    private double price;

    /*
    Fetch Types
    - it determines whether child entity is fetched
    along with parent entity or not

    EAGER:  parent -> parent + child
    LAZY:   parent -> parent

    //default fetch types:
    @OneToOne, @ManyToOne : EAGER
    @OneToMany, @ManyToMany : LAZY
     */
    @OneToOne(fetch = FetchType.LAZY)
    private Engine engine;
}

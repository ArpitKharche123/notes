package o2o.bi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String brand;
    private double price;

    /*
    Cascade Types
     cascading: process where operations performed on parent entity
     will be propagated to the child entity

     e.g: saving parent entity automatically save child entity
     deleting parent entity will also delete child entity
     */
    @OneToOne(cascade = {CascadeType.PERSIST
            ,CascadeType.REMOVE}
    /*
        If child entity is disconnected from the parent entity,
        it will be removed/deleted from the table
     */
    ,orphanRemoval = true)
    @JoinColumn//Foreign key column will be created here
    private SimCard sim;

}

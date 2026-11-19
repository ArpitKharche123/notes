package o2o.bi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SimCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String networkType;

    @OneToOne(mappedBy = "sim")
    private Mobile mobile;
}

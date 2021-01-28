package net.cyllene.gasprice.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cars")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String vin;
    private BigDecimal estimatedConsumption;
    @Lob
    private Byte[] image;
}

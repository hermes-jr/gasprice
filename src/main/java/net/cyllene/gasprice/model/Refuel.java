package net.cyllene.gasprice.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "refuels")
@Data
public class Refuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Petrol petrol;
    @ManyToOne
    private Car car;
    private BigDecimal amount;
    private BigDecimal price;
    private Integer mileage;
    private LocalDateTime datetime;
}

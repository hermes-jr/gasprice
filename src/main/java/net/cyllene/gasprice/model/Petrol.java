package net.cyllene.gasprice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "petrols")
@Data
public class Petrol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}

package net.cyllene.gasprice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "refuels")
@Data
public class Refuelling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}

package net.cyllene.gasprice.dto;

import lombok.Data;
import net.cyllene.gasprice.model.Refuel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RefuelDto {
    private Integer id;
    private String petrolName;
    private String carName;
    private BigDecimal amount;
    private BigDecimal price;
    private Integer mileage;
    private LocalDateTime datetime;

    public RefuelDto(Refuel model) {
        this.id = model.getId();
        this.petrolName = model.getPetrol().getName();
        this.carName = model.getCar().getName();
        this.amount = model.getAmount();
        this.price = model.getPrice();
        this.mileage = model.getMileage();
        this.datetime = model.getDatetime();
    }
}

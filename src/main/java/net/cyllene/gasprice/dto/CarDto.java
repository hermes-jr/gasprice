package net.cyllene.gasprice.dto;

import lombok.Data;
import net.cyllene.gasprice.model.Car;

import java.math.BigDecimal;

@Data
public class CarDto {
    private int id;
    private String name;
    private String vin;
    private BigDecimal estimatedConsumption;

    public CarDto(Car model) {
        id = model.getId();
        name = model.getName();
        vin = model.getVin();
        estimatedConsumption = model.getEstimatedConsumption();
    }
}

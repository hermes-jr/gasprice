package net.cyllene.gasprice.dto;

import lombok.Data;
import net.cyllene.gasprice.model.Car;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Base64;

@Data
public class CarDto {
    private int id;
    private String name;
    private String imageBase64;
    private String vin;
    private BigDecimal estimatedConsumption;

    public CarDto(Car model) {
        id = model.getId();
        name = model.getName();
        vin = model.getVin();
        estimatedConsumption = model.getEstimatedConsumption();
        imageBase64 = Base64.getMimeEncoder().encodeToString(model.getImage());
    }
}

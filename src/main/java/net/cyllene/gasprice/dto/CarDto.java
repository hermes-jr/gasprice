package net.cyllene.gasprice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.cyllene.gasprice.model.Car;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Base64;

@Data
@NoArgsConstructor
public class CarDto {
    private Integer id;

    @Size(min = 1, max = 128)
    @NotBlank
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

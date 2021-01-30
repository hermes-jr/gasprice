package net.cyllene.gasprice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.cyllene.gasprice.model.Refuel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RefuelDto {
    private Integer id;
    @NotNull(message = "must not be empty")
    private IdNameDto petrol;
    @NotNull(message = "must not be empty")
    private IdNameDto car;
    @NotNull(message = "must not be empty")
    private BigDecimal amount;
    @NotNull(message = "must not be empty")
    private BigDecimal price;
    @NotNull(message = "must not be empty")
    private Integer mileage;
    @NotNull(message = "must not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime datetime;

    public RefuelDto(Refuel model) {
        this.id = model.getId();
        this.petrol = new IdNameDto(model.getPetrol().getId(), model.getPetrol().getName());
        this.car = new IdNameDto(model.getCar().getId(), model.getCar().getName());
        this.amount = model.getAmount();
        this.price = model.getPrice();
        this.mileage = model.getMileage();
        this.datetime = model.getDatetime();
    }
}

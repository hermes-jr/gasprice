package net.cyllene.gasprice.dto;

import lombok.Data;
import net.cyllene.gasprice.model.Petrol;

@Data
public class PetrolDto {
    private int id;
    private String name;

    public PetrolDto(Petrol model) {
        id = model.getId();
        name = model.getName();
    }
}

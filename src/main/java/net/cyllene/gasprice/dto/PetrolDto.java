package net.cyllene.gasprice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.cyllene.gasprice.model.Petrol;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class PetrolDto {
    private Integer id;

    @Size(min = 1, max = 128)
    @NotBlank
    private String name;

    public PetrolDto(Petrol model) {
        id = model.getId();
        name = model.getName();
    }
}

package net.cyllene.gasprice;

import net.cyllene.gasprice.dto.IdNameDto;
import org.springframework.format.Formatter;

import java.util.Locale;

public class IdMapDtoFormatter implements Formatter<IdNameDto> {
    @Override
    public IdNameDto parse(String id, Locale locale) {
        IdNameDto r = new IdNameDto();
        r.setId(Integer.parseInt(id));
        return r;
    }

    @Override
    public String print(IdNameDto r, Locale locale) {
        return String.valueOf(r.getId());
    }
}

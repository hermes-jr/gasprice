package net.cyllene.gasprice.controller;

import lombok.RequiredArgsConstructor;
import net.cyllene.gasprice.dto.CarDto;
import net.cyllene.gasprice.dto.PetrolDto;
import net.cyllene.gasprice.model.Car;
import net.cyllene.gasprice.model.Petrol;
import net.cyllene.gasprice.service.PetrolService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class PetrolController {
    private final PetrolService petrolService;

    @GetMapping(value = "/petrols")
    public String petrolsPage(Model model) {
        List<Petrol> petrols = petrolService.findAll();

        List<PetrolDto> dtoList = petrols.stream()
                .map(PetrolDto::new)
                .collect(Collectors.toList());

        model.addAttribute("petrols", dtoList);

        return "petrols";
    }
}

package net.cyllene.gasprice.controller;

import lombok.RequiredArgsConstructor;
import net.cyllene.gasprice.dto.PetrolDto;
import net.cyllene.gasprice.model.Petrol;
import net.cyllene.gasprice.service.PetrolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping(value = "/petrols/add")
    public String addPetrolPage(Model model) {
        model.addAttribute("petrol", new PetrolDto());
        return "petrols_add";
    }

    @PostMapping("/petrols/add")
    public String newPetrolSubmit(@Valid @ModelAttribute("petrol") PetrolDto petrol,
                                  BindingResult bindingResult,
                                  Model model) {
        System.out.println("NEW PETROL REQUEST: " + petrol);
        System.out.println("BR: " + bindingResult);
        model.addAttribute("petrol", petrol);
        if (bindingResult.hasErrors()) {
            return "petrols_add";
        }
        // TODO: check and report unique name constraint
        petrolService.persist(petrol);
        return "redirect:/petrols";
    }

}

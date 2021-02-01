package net.cyllene.gasprice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
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
import java.util.logging.Level;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Log
public class PetrolController {
    private final PetrolService petrolService;

    @GetMapping(value = "/petrols")
    public String petrolsListPage(Model model) {
        List<Petrol> petrols = petrolService.findAll();

        List<PetrolDto> dtoList = petrols.stream()
                .map(PetrolDto::new)
                .collect(Collectors.toList());

        model.addAttribute("petrols", dtoList);

        return "petrols";
    }

    @GetMapping(value = "/petrols/add")
    public String petrolAddPage(Model model) {
        model.addAttribute("petrol", new PetrolDto());
        return "petrols_add";
    }

    @PostMapping("/petrols/add")
    public String petrolAddProcessForm(@ModelAttribute("petrol") @Valid  PetrolDto petrolDto,
                                       BindingResult bindingResult,
                                       Model model) {
        log.log(Level.FINE, "New petrol creation request: " + petrolDto);
        log.log(Level.FINEST, "Binding result: " + bindingResult);

        model.addAttribute("petrol", petrolDto);

        if (bindingResult.hasErrors()) {
            return "petrols_add";
        }

        // TODO: check and report unique name constraint
        petrolService.persist(petrolDto);

        return "redirect:/petrols";
    }

}

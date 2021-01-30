package net.cyllene.gasprice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import net.cyllene.gasprice.dto.IdNameDto;
import net.cyllene.gasprice.dto.RefuelDto;
import net.cyllene.gasprice.model.Refuel;
import net.cyllene.gasprice.service.CarService;
import net.cyllene.gasprice.service.PetrolService;
import net.cyllene.gasprice.service.RefuelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Log
public class RefuelController {
    private final RefuelService refuelService;
    private final CarService carService;
    private final PetrolService petrolService;

    @GetMapping(value = "/")
    public String petrolsPage(Model model) {
        RefuelDto refuel = new RefuelDto();
        refuel.setDatetime(LocalDateTime.now());
        refuel.setPetrol(new IdNameDto(3, null)); // TODO: get latest
        refuel.setCar(new IdNameDto(3, null));  // TODO: get latest

        setDropdownContents(model);
        model.addAttribute("refuel", refuel);

        return "refuels_add";
    }

    @PostMapping("/")
    public String newPetrolSubmit(@ModelAttribute("refuel") @Valid RefuelDto refuelDto,
                                  BindingResult bindingResult,
                                  Model model) {
        log.log(Level.FINE, "New refuel creation request: " + refuelDto);
        log.log(Level.FINEST, "Binding result: " + bindingResult);

        setDropdownContents(model);
        model.addAttribute("refuel", refuelDto);

        if (bindingResult.hasErrors()) {
            return "refuels_add";
        }

        refuelService.persist(refuelDto);

        return "redirect:/refuels";
    }

    private void setDropdownContents(Model model) {
        List<IdNameDto> allCars = carService.findAll().stream()
                .map(c -> new IdNameDto(c.getId(), c.getName()))
                .collect(Collectors.toList());

        List<IdNameDto> allPetrols = petrolService.findAll().stream()
                .map(p -> new IdNameDto(p.getId(), p.getName()))
                .collect(Collectors.toList());

        model.addAttribute("allCars", allCars);
        model.addAttribute("allPetrols", allPetrols);
    }

    @GetMapping(value = "/refuels")
    public String petrolsListPage(Model model) {
        List<Refuel> refuels = refuelService.listForSummary();

        List<RefuelDto> dtoList = refuels.stream()
                .map(RefuelDto::new)
                .collect(Collectors.toList());

        model.addAttribute("refuels", dtoList);

        return "summary";
    }
}

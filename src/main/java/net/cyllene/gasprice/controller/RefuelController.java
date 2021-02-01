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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
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
    public String refuelAddPage(Model model) {
        RefuelDto refuel = new RefuelDto();
        refuel.setDatetime(LocalDateTime.now());
        refuel.setPetrol(new IdNameDto(3, null)); // TODO: get latest
        refuel.setCar(new IdNameDto(3, null));  // TODO: get latest

        setDropdownContents(model);
        model.addAttribute("refuel", refuel);

        return "refuels_add";
    }

    @PostMapping("/")
    public String refuelAddProcessForm(@ModelAttribute("refuel") @Valid RefuelDto refuelDto,
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
    public String refuelsListPage(Model model) {
        List<Refuel> refuels = refuelService.listForSummary();

        List<RefuelDto> dtoList = refuels.stream()
                .map(RefuelDto::new)
                .collect(Collectors.toList());

        model.addAttribute("refuels", dtoList);

        List<RefuelDto> reversedDtoList = new ArrayList<>(dtoList);
        Collections.reverse(reversedDtoList);
        List<LocalDateTime> chartDates = reversedDtoList.stream().map(RefuelDto::getDatetime).collect(Collectors.toList());
        List<BigDecimal> chartPrices = reversedDtoList.stream().map(RefuelDto::getPrice).collect(Collectors.toList());
        List<BigDecimal> chartAmounts = reversedDtoList.stream().map(RefuelDto::getAmount).collect(Collectors.toList());

        model.addAttribute("chartDates", chartDates);
        model.addAttribute("chartPrices", chartPrices);
        model.addAttribute("chartAmounts", chartAmounts);

        return "summary";
    }
}

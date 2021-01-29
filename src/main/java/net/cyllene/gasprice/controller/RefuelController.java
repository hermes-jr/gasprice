package net.cyllene.gasprice.controller;

import lombok.RequiredArgsConstructor;
import net.cyllene.gasprice.dto.RefuelDto;
import net.cyllene.gasprice.model.Refuel;
import net.cyllene.gasprice.service.RefuelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class RefuelController {
    private final RefuelService refuelService;

    @GetMapping(value = "/")
    public String petrolsPage(Model model) {
        List<Refuel> refuels = refuelService.listForSummary();

        List<RefuelDto> dtoList = refuels.stream()
                .map(RefuelDto::new)
                .collect(Collectors.toList());

        model.addAttribute("refuels", dtoList);

        return "summary";
    }
}

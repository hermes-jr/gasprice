package net.cyllene.gasprice.controller;

import lombok.RequiredArgsConstructor;
import net.cyllene.gasprice.dto.CarDto;
import net.cyllene.gasprice.model.Car;
import net.cyllene.gasprice.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping(value = "/cars")
    public String carsPage(
            Model model,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size) {
        int currentPage = page == null ? 1 : page;
        int pageSize = size == null ? 5 : size;

        Page<Car> carsPage = carService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        List<CarDto> pageAsDto = carsPage.stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
        Page<CarDto> r = new PageImpl<>(pageAsDto, carsPage.getPageable(), carsPage.getTotalElements());

        model.addAttribute("currentCarsTablePage", r);

        int totalPages = carsPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "cars";
    }
}

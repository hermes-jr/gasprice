package net.cyllene.gasprice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class HelloWorldController {
/*    @Inject
    private final CarService carService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("tasks", Arrays.asList("a", "b", "c", "d", "e", "f", "g"));

        return "welcome"; //view
    }

    @GetMapping("/hello")
    public String mainWithParam(@RequestParam(name = "name", required = false, defaultValue = "") String name,
                                Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }

    @GetMapping("/zzz")
    public String zzzPage(Model model) {
        model.addAttribute("message", "z");
        return "zzz"; //view
    }

    @GetMapping(value = "/listBooks")
    public String listBooks(
            Model model,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size) {
        int currentPage = page == null ? 1 : page;
        int pageSize = size == null ? 5 : size;

        Page<Book> bookPage = carService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        List<CarDto> pageAsDto = bookPage.stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
        Page<CarDto> r = new PageImpl<>(pageAsDto, bookPage.getPageable(), bookPage.getTotalElements());

        model.addAttribute("currentCarsTablePage", r);

        int totalPages = bookPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "books";
    }*/
}

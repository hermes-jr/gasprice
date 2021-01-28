package net.cyllene.gasprice.service;

import lombok.RequiredArgsConstructor;
import net.cyllene.gasprice.model.Car;
import net.cyllene.gasprice.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
@RequiredArgsConstructor
public class CarService {
    @Inject
    private final CarRepository carRepository;

    public Page<Car> findPaginated(Pageable pageable) {
        return carRepository.findAll(pageable);
    }
}
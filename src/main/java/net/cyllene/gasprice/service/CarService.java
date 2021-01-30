package net.cyllene.gasprice.service;

import lombok.RequiredArgsConstructor;
import net.cyllene.gasprice.dto.CarDto;
import net.cyllene.gasprice.model.Car;
import net.cyllene.gasprice.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Page<Car> findPaginated(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    public void persist(CarDto dto) throws IOException {
        Car car = new Car();
        car.setId(dto.getId() == null || dto.getId().equals(0) ? null : dto.getId());
        car.setName(dto.getName());
        car.setVin(dto.getVin());
        car.setEstimatedConsumption(dto.getEstimatedConsumption());
        car.setImage(dto.getImage().getBytes());
        carRepository.saveAndFlush(car);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }
}
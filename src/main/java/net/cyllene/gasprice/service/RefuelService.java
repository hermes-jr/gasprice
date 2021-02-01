package net.cyllene.gasprice.service;

import lombok.RequiredArgsConstructor;
import net.cyllene.gasprice.dto.RefuelDto;
import net.cyllene.gasprice.model.Refuel;
import net.cyllene.gasprice.repository.CarRepository;
import net.cyllene.gasprice.repository.PetrolRepository;
import net.cyllene.gasprice.repository.RefuelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefuelService {
    private final RefuelRepository refuelRepository;
    private final CarRepository carRepository;
    private final PetrolRepository petrolRepository;

    public List<Refuel> listForSummary() {
        return refuelRepository.findAllByOrderByDatetimeDesc();
    }

    public void persist(RefuelDto dto) {
        Refuel refuel = new Refuel();
        refuel.setId(dto.getId() == null || dto.getId().equals(0) ? null : dto.getId());
        refuel.setDatetime(dto.getDatetime());
        refuel.setCar(carRepository.findById(dto.getCar().getId()).orElseThrow());
        refuel.setPetrol(petrolRepository.findById(dto.getPetrol().getId()).orElseThrow());
        refuel.setPrice(dto.getPrice());
        refuel.setAmount(dto.getAmount());
        refuel.setMileage(dto.getMileage());
        refuelRepository.saveAndFlush(refuel);
    }
}
package net.cyllene.gasprice.service;

import lombok.RequiredArgsConstructor;
import net.cyllene.gasprice.dto.RefuelDto;
import net.cyllene.gasprice.model.Car;
import net.cyllene.gasprice.model.Petrol;
import net.cyllene.gasprice.model.Refuel;
import net.cyllene.gasprice.repository.RefuelRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RefuelService {
    private final RefuelRepository refuelRepository;
    private final EntityManager entityManager;

    public List<Refuel> listForSummary() {
        return refuelRepository.findAllByOrderByDatetimeDesc();
    }

    public void persist(RefuelDto dto) {
        Refuel refuel = new Refuel();
        refuel.setId(dto.getId() == null || dto.getId().equals(0) ? null : dto.getId());
        refuel.setDatetime(dto.getDatetime());
        refuel.setCar(entityManager.getReference(Car.class, dto.getCar().getId()));
        refuel.setPetrol(entityManager.getReference(Petrol.class, dto.getPetrol().getId()));
        refuel.setPrice(dto.getPrice());
        refuel.setAmount(dto.getAmount());
        refuel.setMileage(dto.getMileage());
        refuelRepository.saveAndFlush(refuel);
    }
}
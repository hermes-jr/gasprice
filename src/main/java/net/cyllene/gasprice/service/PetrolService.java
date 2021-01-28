package net.cyllene.gasprice.service;

import lombok.RequiredArgsConstructor;
import net.cyllene.gasprice.model.Car;
import net.cyllene.gasprice.model.Petrol;
import net.cyllene.gasprice.repository.CarRepository;
import net.cyllene.gasprice.repository.PetrolRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetrolService {
    private final PetrolRepository petrolRepository;

    public List<Petrol> findAll() {
        return petrolRepository.findAll();
    }
}
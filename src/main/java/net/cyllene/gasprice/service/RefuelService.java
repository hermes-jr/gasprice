package net.cyllene.gasprice.service;

import lombok.RequiredArgsConstructor;
import net.cyllene.gasprice.dto.RefuelDto;
import net.cyllene.gasprice.model.Refuel;
import net.cyllene.gasprice.repository.RefuelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefuelService {
    private final RefuelRepository refuelRepository;

    public List<Refuel> listForSummary() {
        return refuelRepository.findAllByOrderByDatetimeDesc();
    }

    public void persist(RefuelDto dto) {
        Refuel refuel = new Refuel();
        refuel.setId(dto.getId() == null || dto.getId().equals(0) ? null : dto.getId());
//        refuel.setName(dto.getName());
//        refuelRepository.saveAndFlush(refuel);
    }
}
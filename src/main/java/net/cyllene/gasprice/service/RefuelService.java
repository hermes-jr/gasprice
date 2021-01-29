package net.cyllene.gasprice.service;

import lombok.RequiredArgsConstructor;
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
}
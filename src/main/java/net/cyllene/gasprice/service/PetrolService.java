package net.cyllene.gasprice.service;

import lombok.RequiredArgsConstructor;
import net.cyllene.gasprice.dto.PetrolDto;
import net.cyllene.gasprice.model.Petrol;
import net.cyllene.gasprice.repository.PetrolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetrolService {
    private final PetrolRepository petrolRepository;

    public List<Petrol> findAll() {
        return petrolRepository.findAll();
    }

    public void persist(PetrolDto dto) {
        Petrol petrol = new Petrol();
        petrol.setId(dto.getId() == null || dto.getId().equals(0) ? null : petrol.getId());
        petrol.setName(dto.getName());
        petrolRepository.saveAndFlush(petrol);
    }
}
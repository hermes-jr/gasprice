package net.cyllene.gasprice.repository;

import net.cyllene.gasprice.model.Car;
import net.cyllene.gasprice.model.Petrol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetrolRepository extends JpaRepository<Petrol, Integer> {
}

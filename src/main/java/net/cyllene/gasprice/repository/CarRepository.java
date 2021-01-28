package net.cyllene.gasprice.repository;

import net.cyllene.gasprice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}

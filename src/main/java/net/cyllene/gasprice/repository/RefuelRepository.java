package net.cyllene.gasprice.repository;

import net.cyllene.gasprice.model.Refuel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RefuelRepository extends JpaRepository<Refuel, Integer> {
    List<Refuel> findAllByOrderByDatetimeDesc();
}

package ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.PowerSupply;

@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply,Integer> {
}

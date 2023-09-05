package ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Computer;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Integer> {
}

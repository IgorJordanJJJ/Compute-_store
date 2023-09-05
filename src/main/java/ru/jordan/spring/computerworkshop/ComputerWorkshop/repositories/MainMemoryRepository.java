package ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.MainMemory;

@Repository
public interface MainMemoryRepository extends JpaRepository<MainMemory, Integer> {
}

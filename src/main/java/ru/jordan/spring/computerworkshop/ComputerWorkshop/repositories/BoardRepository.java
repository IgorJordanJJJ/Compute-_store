package ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Board;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.CPU;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
}

package ru.jordan.spring.computerworkshop.ComputerWorkshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.MainMemory;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories.MainMemoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MainMemoryService {
    public final MainMemoryRepository mainMemoryRepository;

    @Autowired
    public MainMemoryService(MainMemoryRepository mainMemoryRepository) {
        this.mainMemoryRepository = mainMemoryRepository;
    }

    public List<MainMemory> findAll() {
        return mainMemoryRepository.findAll();
    }

    public MainMemory findOne(int id) {
        Optional<MainMemory> foundMainMemory = mainMemoryRepository.findById(id);
        return foundMainMemory.orElse(null);
    }

    @Transactional
    public void save(MainMemory mainMemory) {
        mainMemoryRepository.save(mainMemory);
    }

    @Transactional
    public void update(int id, MainMemory mainMemory) {
        mainMemory.setId(id);
        mainMemoryRepository.save(mainMemory);
    }

    @Transactional
    public void delete(int id) {
        mainMemoryRepository.deleteById(id);
    }
}

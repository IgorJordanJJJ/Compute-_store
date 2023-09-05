package ru.jordan.spring.computerworkshop.ComputerWorkshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.MainMemory;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.PowerSupply;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories.PowerSupplyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PowerSupplyService {

    private final PowerSupplyRepository powerSupplyRepository;

    @Autowired
    public PowerSupplyService(PowerSupplyRepository powerSupplyRepository) {
        this.powerSupplyRepository = powerSupplyRepository;
    }

    public List<PowerSupply> findAll() {
        return powerSupplyRepository.findAll();
    }

    public PowerSupply findOne(int id) {
        Optional<PowerSupply> foundPowerSupply = powerSupplyRepository.findById(id);
        return foundPowerSupply.orElse(null);
    }

    @Transactional
    public void save(PowerSupply powerSupply) {
        powerSupplyRepository.save(powerSupply);
    }

    @Transactional
    public void update(int id, PowerSupply powerSupply) {
        powerSupply.setId(id);
        powerSupplyRepository.save(powerSupply);
    }

    @Transactional
    public void delete(int id) {
        powerSupplyRepository.deleteById(id);
    }

}

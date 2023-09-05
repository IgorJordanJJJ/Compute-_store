package ru.jordan.spring.computerworkshop.ComputerWorkshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Master;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.PowerSupply;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories.MainMemoryRepository;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories.MasterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MasterService {

    public final MasterRepository masterRepository;

    @Autowired
    public MasterService(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    public List<Master> findAll() {
        return masterRepository.findAll();
    }

    public Master findOne(int id) {
        Optional<Master> foundMaster = masterRepository.findById(id);
        return foundMaster.orElse(null);
    }

    @Transactional
    public void save(Master master) {
        masterRepository.save(master);
    }

    @Transactional
    public void update(int id, Master master) {
        master.setId(id);
        masterRepository.save(master);
    }

    @Transactional
    public void delete(int id) {
        masterRepository.deleteById(id);
    }
}

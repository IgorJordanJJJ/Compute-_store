package ru.jordan.spring.computerworkshop.ComputerWorkshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Case;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.CoolingSystem;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories.CoolingSystemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CoolingSystemService {


    private final CoolingSystemRepository coolingSystemRepository;

    @Autowired
    public CoolingSystemService(CoolingSystemRepository coolingSystemRepository) {
        this.coolingSystemRepository = coolingSystemRepository;
    }

    public List<CoolingSystem> findAll(){return coolingSystemRepository.findAll();}

    public CoolingSystem findOne(int id){

        Optional<CoolingSystem> foundCase =  coolingSystemRepository.findById(id);
        return foundCase.orElse(null);
    }

    @Transactional
    public void save(CoolingSystem coolingSystem){
        coolingSystemRepository.save(coolingSystem);
    }

    @Transactional
    public void update(int id, CoolingSystem coolingSystem) {
        coolingSystem.setId(id);
        coolingSystemRepository.save(coolingSystem);
    }

    @Transactional
    public void delete(int id) {
        coolingSystemRepository.deleteById(id);
    }

}

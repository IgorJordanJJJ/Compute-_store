package ru.jordan.spring.computerworkshop.ComputerWorkshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Case;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Computer;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.CoolingSystem;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories.ComputerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {

    public final ComputerRepository computerRepository;

    @Autowired
    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }
    public List<Computer> findAll(){return computerRepository.findAll();}

    public Computer findOne(int id){

        Optional<Computer> foundCase =  computerRepository.findById(id);
        return foundCase.orElse(null);
    }

    @Transactional
    public void save(Computer computer){
        computerRepository.save(computer);
    }

    @Transactional
    public void update(int id, Computer computer) {
        computer.setId(id);
        computerRepository.save(computer);
    }

    @Transactional
    public void delete(int id) {
        computerRepository.deleteById(id);
    }

}

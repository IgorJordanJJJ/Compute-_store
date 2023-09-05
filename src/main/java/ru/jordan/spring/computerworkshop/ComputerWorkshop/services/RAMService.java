package ru.jordan.spring.computerworkshop.ComputerWorkshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.RAM;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories.RAMRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RAMService {
    private final RAMRepository ramRepository;

    @Autowired
    public RAMService(RAMRepository ramRepository) {
        this.ramRepository = ramRepository;
    }


    public List<RAM> findAll() {
        return ramRepository.findAll();
    }

    public RAM findOne(int id) {
        Optional<RAM> foundRAM = ramRepository.findById(id);
        return foundRAM.orElse(null);
    }

    @Transactional
    public void save(RAM ram) {
        ramRepository.save(ram);
    }

    @Transactional
    public void update(int id, RAM ramupdate) {
        ramupdate.setId(id);
        ramRepository.save(ramupdate);
    }

    @Transactional
    public void delet(int id) {
        ramRepository.deleteById(id);
    }


}

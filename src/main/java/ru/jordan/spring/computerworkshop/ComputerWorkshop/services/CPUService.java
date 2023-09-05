package ru.jordan.spring.computerworkshop.ComputerWorkshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.CPU;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories.CPURepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CPUService {

    private final CPURepository cpuRepository;


    @Autowired
    public CPUService(CPURepository cpuRepository) {
        this.cpuRepository = cpuRepository;
    }


    public List<CPU> findAll() {
        return cpuRepository.findAll();
    }

    public CPU findOne(int id) {
        Optional<CPU> foundCPU = cpuRepository.findById(id);

        return foundCPU.orElse(null);

    }

    @Transactional
    public void save(CPU cpu) {
        cpuRepository.save(cpu);
    }

    @Transactional
    public void update(int id, CPU updatecpu) {
        updatecpu.setId(id);
        cpuRepository.save(updatecpu);
    }

    @Transactional
    public void delete(int id) {
        cpuRepository.deleteById(id);
    }

}

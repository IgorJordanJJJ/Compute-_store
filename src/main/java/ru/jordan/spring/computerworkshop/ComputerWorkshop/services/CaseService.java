package ru.jordan.spring.computerworkshop.ComputerWorkshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Case;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories.CaseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CaseService {

    private final CaseRepository caseRepository;

    @Autowired
    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public List<Case> findAll(){return caseRepository.findAll();}

    public Case findOne(int id){

        Optional<Case> foundCase =  caseRepository.findById(id);
        return foundCase.orElse(null);
    }

    @Transactional
    public void save(Case casec){
        caseRepository.save(casec);
    }

    @Transactional
    public void update(int id, Case casec) {
        casec.setId(id);
        caseRepository.save(casec);
    }

    @Transactional
    public void delete(int id) {
        caseRepository.deleteById(id);
    }


}

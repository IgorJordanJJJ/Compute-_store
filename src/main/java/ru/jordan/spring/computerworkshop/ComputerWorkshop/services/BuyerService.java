package ru.jordan.spring.computerworkshop.ComputerWorkshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Buyer;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Master;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories.BuyerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {
    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    public Buyer findOne(int id) {
        Optional<Buyer> foundBuyer = buyerRepository.findById(id);
        return foundBuyer.orElse(null);
    }

    @Transactional
    public void save(Buyer buyer) {
        buyerRepository.save(buyer);
    }

    @Transactional
    public void update(int id, Buyer buyer) {
        buyer.setId(id);
        buyerRepository.save(buyer);
    }

    @Transactional
    public void delete(int id) {
        buyerRepository.deleteById(id);
    }
}

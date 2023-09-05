package ru.jordan.spring.computerworkshop.ComputerWorkshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.CPU;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.CoolingSystem;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.GraphicCard;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories.GraphicCardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GraphicCardService {
    public final GraphicCardRepository graphicCardRepository;

    @Autowired
    public GraphicCardService(GraphicCardRepository graphicCardRepository) {
        this.graphicCardRepository = graphicCardRepository;
    }

    public List<GraphicCard> findAll() {
        return graphicCardRepository.findAll();
    }

    public GraphicCard findOne(int id) {
        Optional<GraphicCard> foundGraphicCard = graphicCardRepository.findById(id);
        return foundGraphicCard.orElse(null);
    }

    @Transactional
    public void save(GraphicCard graphicCard) {
        graphicCardRepository.save(graphicCard);
    }

    @Transactional
    public void update(int id, GraphicCard graphicCard) {
        graphicCard.setId(id);
        graphicCardRepository.save(graphicCard);
    }

    @Transactional
    public void delete(int id) {
        graphicCardRepository.deleteById(id);
    }

}

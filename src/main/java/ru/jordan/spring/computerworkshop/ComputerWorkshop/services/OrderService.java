package ru.jordan.spring.computerworkshop.ComputerWorkshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Case;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Orders;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Orders> findAll(){return orderRepository.findAll();}

    public Orders findOne(int id){

        Optional<Orders> foundCase =  orderRepository.findById(id);
        return foundCase.orElse(null);
    }

    @Transactional
    public void save(Orders orders){
        orderRepository.save(orders);
    }

    @Transactional
    public void update(int id, Orders orders) {
        orders.setId(id);
        orderRepository.save(orders);
    }

    @Transactional
    public void delete(int id) {
        orderRepository.deleteById(id);
    }

}

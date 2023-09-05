package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.MainMemory;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Orders;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.OrderService;

import javax.validation.Valid;

@Controller
@RequestMapping("/store")
public class MainController {

    public final OrderService orderService;

    @Autowired
    public MainController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public String index(Model model, @ModelAttribute("order")Orders orders) {
        return "store/main";
    }

    @GetMapping("/ordersearch")
    public String search(Model model,@RequestParam(required = false) int id, @ModelAttribute("orders")Orders orders) {
        model.addAttribute("orders",orderService.findOne(id));
        return "store/ordersearch";
    }


}

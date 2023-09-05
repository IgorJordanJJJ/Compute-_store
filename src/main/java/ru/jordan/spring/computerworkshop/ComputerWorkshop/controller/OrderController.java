package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Buyer;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Computer;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Master;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Orders;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.BuyerService;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.ComputerService;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.MasterService;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.OrderService;

import javax.validation.Valid;

@Controller
@RequestMapping("/order")
public class OrderController {

    public final OrderService orderService;
    public final ComputerService computerService;
    public final MasterService masterService;
    public final BuyerService buyerService;


    @Autowired
    public OrderController(OrderService orderService, ComputerService computerService, MasterService masterService, BuyerService buyerService) {
        this.orderService = orderService;
        this.computerService = computerService;
        this.masterService = masterService;
        this.buyerService = buyerService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "order/all";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("order", orderService.findOne(id));
        return "order/show";
    }

    @GetMapping("/new")
    public String newOrder(Model model, @ModelAttribute("order") Orders orders, @ModelAttribute("computers") Computer computer,
                           @ModelAttribute("masters") Master master, @ModelAttribute("buyers") Buyer buyer) {
        model.addAttribute("computers", computerService.findAll());
        model.addAttribute("masters", masterService.findAll());
        model.addAttribute("buyers", buyerService.findAll());

        return "order/new";
    }

    @PostMapping()
    public String create(Model model, @ModelAttribute("order") @Valid Orders orders, BindingResult bindingResult,@ModelAttribute("computers") Computer computer,
                         @ModelAttribute("masters") Master master, @ModelAttribute("buyers") Buyer buyer) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("computers", computerService.findAll());
            model.addAttribute("masters", masterService.findAll());
            model.addAttribute("buyers", buyerService.findAll());
            return "order/new";
        }
        orderService.save(orders);
        return "redirect:/order";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id, @ModelAttribute("order") Orders orders, @ModelAttribute("computers") Computer computer,
                       @ModelAttribute("masters") Master master, @ModelAttribute("buyers") Buyer buyer) {
        model.addAttribute("order", orderService.findOne(id));
        model.addAttribute("computers", computerService.findAll());
        model.addAttribute("masters", masterService.findAll());
        model.addAttribute("buyers", buyerService.findAll());
        return "order/edit";
    }

    @PatchMapping("/{id}")
    public String update(Model model,@ModelAttribute("order") @Valid Orders orders, BindingResult bindingResult, @PathVariable("id") int id, @ModelAttribute("computers") Computer computer,
                         @ModelAttribute("masters") Master master, @ModelAttribute("buyers") Buyer buyer) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("computers", computerService.findAll());
            model.addAttribute("masters", masterService.findAll());
            model.addAttribute("buyers", buyerService.findAll());
            return "order/edit";
        }
        orderService.update(id, orders);
        return "redirect:/order";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        orderService.delete(id);
        return "redirect:/order";
    }
}

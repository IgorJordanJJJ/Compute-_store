package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Buyer;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Master;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.BuyerService;

import javax.validation.Valid;

@Controller
@RequestMapping("/buyer")
public class BuyerConstroller {

    private final BuyerService buyerService;

    @Autowired
    public BuyerConstroller(BuyerService buyerService) {
        this.buyerService = buyerService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("buyers", buyerService.findAll());
        return "buyer/all";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("buyer", buyerService.findOne(id));
        return "buyer/show";
    }

    @GetMapping("/new")
    public String newBuyer(@ModelAttribute("buyer") Buyer buyer) {
        return "buyer/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("buyer") @Valid Buyer buyer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "buyer/new";
        }
        buyerService.save(buyer);
        return "redirect:/buyer";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("buyer", buyerService.findOne(id));
        return "buyer/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("buyer") @Valid Buyer buyer, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "buyer/edit";
        }
        buyerService.update(id, buyer);
        return "redirect:/buyer";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        buyerService.delete(id);
        return "redirect:/buyer";
    }

}

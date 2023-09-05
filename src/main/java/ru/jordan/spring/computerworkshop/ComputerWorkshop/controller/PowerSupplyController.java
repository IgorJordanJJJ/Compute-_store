package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.MainMemory;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.PowerSupply;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.PowerSupplyService;

import javax.validation.Valid;

@Controller
@RequestMapping("/powersupply")
public class PowerSupplyController {

    private final PowerSupplyService powerSupplyService;

    @Autowired
    public PowerSupplyController(PowerSupplyService powerSupplyService) {
        this.powerSupplyService = powerSupplyService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("powersupplis", powerSupplyService.findAll());
        return "powersupply/all";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("powersupply", powerSupplyService.findOne(id));
        return "powersupply/show";
    }

    @GetMapping("/new")
    public String newPowerSupply(@ModelAttribute("powersupply")PowerSupply powerSupply) {
        return "powersupply/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("powersupply") @Valid PowerSupply powerSupply, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "powersupply/new";
        }
        powerSupplyService.save(powerSupply);
        return "redirect:/powersupply";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("powersupply", powerSupplyService.findOne(id));
        return "powersupply/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("powersupply") @Valid PowerSupply powerSupply, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "powersupply/edit";
        }
        powerSupplyService.update(id, powerSupply);
        return "redirect:/powersupply";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        powerSupplyService.delete(id);
        return "redirect:/powersupply";
    }


}

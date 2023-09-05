package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.CPU;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.CoolingSystem;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.CoolingSystemService;

import javax.validation.Valid;

@Controller
@RequestMapping("/coolingsystem")
public class CoolingSystemController {

    private final CoolingSystemService coolingSystemService;

    @Autowired
    public CoolingSystemController(CoolingSystemService coolingSystemService) {
        this.coolingSystemService = coolingSystemService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("coolingsystems", coolingSystemService.findAll());
        return "coolingsystem/all";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("coolingsystem", coolingSystemService.findOne(id));
        return "coolingsystem/show";
    }

    @GetMapping("/new")
    public String newCoolingSystem(@ModelAttribute("coolingsystem") CoolingSystem coolingSystem) {
        return "coolingsystem/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("coolingsystem") @Valid CoolingSystem coolingSystem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "coolingsystem/new";
        }
        coolingSystemService.save(coolingSystem);
        return "redirect:/coolingsystem";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("coolingsystem", coolingSystemService.findOne(id));
        return "coolingsystem/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("coolingsystem") @Valid CoolingSystem coolingSystem, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "coolingsystem/edit";
        }
        coolingSystemService.update(id, coolingSystem);
        return "redirect:/coolingsystem";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        coolingSystemService.delete(id);
        return "redirect:/coolingsystem";
    }
}

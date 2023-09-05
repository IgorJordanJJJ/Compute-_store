package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Master;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.PowerSupply;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.MasterService;

import javax.validation.Valid;

@Controller
@RequestMapping("/master")
public class MasterController {

    public final MasterService masterService;

    @Autowired
    public MasterController(MasterService masterService) {
        this.masterService = masterService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("masters", masterService.findAll());
        return "master/all";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("master", masterService.findOne(id));
        return "master/show";
    }

    @GetMapping("/new")
    public String newMaster(@ModelAttribute("master")Master master) {
        return "master/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("master") @Valid Master master, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "master/new";
        }
        masterService.save(master);
        return "redirect:/master";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("master", masterService.findOne(id));
        return "master/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("master") @Valid Master master, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "master/edit";
        }
        masterService.update(id, master);
        return "redirect:/master";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        masterService.delete(id);
        return "redirect:/master";
    }
}

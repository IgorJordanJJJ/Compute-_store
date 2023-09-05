package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.RAM;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.RAMService;

import javax.validation.Valid;

@Controller
@RequestMapping("/ram")
public class RAMController {

    private final RAMService ramService;

    @Autowired
    public RAMController(RAMService ramService) {
        this.ramService = ramService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("rams", ramService.findAll());
        return "ram/all";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("ram", ramService.findOne(id));
        return "ram/show";
    }

    @GetMapping("/new")
    public String newRAM(@ModelAttribute("ram") RAM ram) {
        return "ram/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("ram") @Valid RAM ram, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/ram/new";
        }
        ramService.save(ram);
        return "redirect:ram";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("ram", ramService.findOne(id));
        return "ram/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("ram") @Valid RAM ram, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "ram/edit";
        }
        ramService.update(id, ram);
        return "redirect:/ram";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        ramService.delet(id);
        return "redirect:/ram";
    }


}

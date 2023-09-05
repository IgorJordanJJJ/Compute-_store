package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.CPU;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.CPUService;

import javax.validation.Valid;

@Controller
@RequestMapping("/cpu")
public class CPUController {

    private final CPUService cpuService;

    @Autowired
    public CPUController(CPUService cpuService) {
        this.cpuService = cpuService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("cpus", cpuService.findAll());
        return "cpu/all";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("cpu", cpuService.findOne(id));
        return "cpu/show";
    }

    @GetMapping("/new")
    public String newCPU(@ModelAttribute("cpu") CPU cpu) {
        return "cpu/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("cpu") @Valid CPU cpu, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cpu/new";
        }
        cpuService.save(cpu);
        return "redirect:/cpu";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("cpu", cpuService.findOne(id));
        return "cpu/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("cpu") @Valid CPU cpu, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "cpu/edit";
        }
        cpuService.update(id, cpu);
        return "redirect:/cpu";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        cpuService.delete(id);
        return "redirect:/cpu";
    }


}

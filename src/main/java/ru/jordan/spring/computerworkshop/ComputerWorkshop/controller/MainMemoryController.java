package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.GraphicCard;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.MainMemory;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.MainMemoryService;

import javax.validation.Valid;

@Controller
@RequestMapping("/mainmemory")
public class MainMemoryController {
    private final MainMemoryService mainMemoryService;

    @Autowired
    public MainMemoryController(MainMemoryService mainMemoryService) {
        this.mainMemoryService = mainMemoryService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("mainmemoris", mainMemoryService.findAll());
        return "mainmemory/all";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("mainmemory", mainMemoryService.findOne(id));
        return "mainmemory/show";
    }

    @GetMapping("/new")
    public String newMainMemory(@ModelAttribute("mainmemory") MainMemory mainMemory) {
        return "mainmemory/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("mainmemory") @Valid MainMemory mainMemory, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "mainmemory/new";
        }
        mainMemoryService.save(mainMemory);
        return "redirect:/mainmemory";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("mainmemory", mainMemoryService.findOne(id));
        return "mainmemory/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("mainmemory") @Valid MainMemory mainMemory, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "mainmemory/edit";
        }
        mainMemoryService.update(id, mainMemory);
        return "redirect:/mainmemory";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        mainMemoryService.delete(id);
        return "redirect:/mainmemory";
    }

}

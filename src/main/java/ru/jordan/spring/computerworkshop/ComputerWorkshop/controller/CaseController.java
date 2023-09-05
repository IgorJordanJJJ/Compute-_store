package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.CPU;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Case;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.CaseService;

import javax.validation.Valid;

@Controller
@RequestMapping("/cases")
public class CaseController {

    private final CaseService caseService;

    @Autowired
    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("casess", caseService.findAll());
        return "cases/all";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("cases", caseService.findOne(id));
        return "cases/show";
    }

    @GetMapping("/new")
    public String newCase(@ModelAttribute("cases") Case cases) {
        return "cases/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("cases") @Valid Case cases, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cases/new";
        }
        caseService.save(cases);
        return "redirect:/cases";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("cases", caseService.findOne(id));
        return "cases/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("cases") @Valid Case cases, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "cases/edit";
        }
        caseService.update(id, cases);
        return "redirect:/cases";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        caseService.delete(id);
        return "redirect:/cases";
    }
}

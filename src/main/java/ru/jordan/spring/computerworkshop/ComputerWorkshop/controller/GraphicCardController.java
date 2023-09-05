package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.CPU;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.GraphicCard;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.GraphicCardService;

import javax.validation.Valid;

@Controller
@RequestMapping("/graphiccard")
public class GraphicCardController {
    public final GraphicCardService graphicCardService;

    @Autowired
    public GraphicCardController(GraphicCardService graphicCardService) {
        this.graphicCardService = graphicCardService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("graphiccards", graphicCardService.findAll());
        return "graphiccard/all";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("graphiccard", graphicCardService.findOne(id));
        return "graphiccard/show";
    }

    @GetMapping("/new")
    public String newGraphicCard(@ModelAttribute("graphiccard") GraphicCard graphicCard) {
        return "graphiccard/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("graphiccard") @Valid GraphicCard graphicCard, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "graphiccard/new";
        }
        graphicCardService.save(graphicCard);
        return "redirect:/graphiccard";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("graphiccard", graphicCardService.findOne(id));
        return "graphiccard/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("graphiccard") @Valid GraphicCard graphicCard, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "graphiccard/edit";
        }
        graphicCardService.update(id, graphicCard);
        return "redirect:/graphiccard";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        graphicCardService.delete(id);
        return "redirect:/graphiccard";
    }

}

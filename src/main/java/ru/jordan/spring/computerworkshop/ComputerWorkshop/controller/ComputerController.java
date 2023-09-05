package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/computer")
public class ComputerController {

    private final ComputerService computerService;

    private final CPUService cpuService;

    private final RAMService ramService;

    private final BoardService boardService;

    private final PowerSupplyService powerSupplyService;

    private final CoolingSystemService coolingSystemService;

    private final CaseService caseService;

    private final MainMemoryService mainMemoryService;

    private final GraphicCardService graphicCardService;

    @Autowired
    public ComputerController(ComputerService computerService, CPUService cpuService, RAMService ramService, BoardService boardService, PowerSupplyService powerSupplyService, CoolingSystemService coolingSystemService, CaseService caseService, MainMemoryService mainMemoryService, GraphicCardService graphicCardService) {
        this.computerService = computerService;
        this.cpuService = cpuService;
        this.ramService = ramService;
        this.boardService = boardService;
        this.powerSupplyService = powerSupplyService;
        this.coolingSystemService = coolingSystemService;
        this.caseService = caseService;
        this.mainMemoryService = mainMemoryService;
        this.graphicCardService = graphicCardService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("computers", computerService.findAll());
        return "computer/all";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("computer", computerService.findOne(id));
        return "computer/show";
    }

    @GetMapping("/new")
    public String newComputer(Model model, @ModelAttribute("computer") Computer computer, @ModelAttribute("cpus") CPU cpu, @ModelAttribute("rams") RAM ram,
                         @ModelAttribute("boards")Board board, @ModelAttribute("powersupplis")PowerSupply powerSupply, @ModelAttribute("coolingsystems") CoolingSystem coolingSystem,
                         @ModelAttribute("casess") Case cases, @ModelAttribute("mainmemoris") MainMemory mainMemory, @ModelAttribute("graphiccards") GraphicCard graphicCard) {
        model.addAttribute("cpus", cpuService.findAll());
        model.addAttribute("rams", ramService.findAll());
        model.addAttribute("boards", boardService.findAll());
        model.addAttribute("powersupplis", powerSupplyService.findAll());
        model.addAttribute("coolingsystems", coolingSystemService.findAll());
        model.addAttribute("casess", caseService.findAll());
        model.addAttribute("mainmemoris", mainMemoryService.findAll());
        model.addAttribute("graphiccards", graphicCardService.findAll());

        return "computer/new";
    }

    @PostMapping()
    public String create(Model model,@ModelAttribute("computer") @Valid Computer computer, BindingResult bindingResult, @ModelAttribute("cpus") CPU cpu, @ModelAttribute("rams") RAM ram,
                         @ModelAttribute("boards")Board board, @ModelAttribute("powersupplis")PowerSupply powerSupply, @ModelAttribute("coolingsystems") CoolingSystem coolingSystem,
                         @ModelAttribute("casess") Case cases, @ModelAttribute("mainmemoris") MainMemory mainMemory, @ModelAttribute("graphiccards") GraphicCard graphicCard) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cpus", cpuService.findAll());
            model.addAttribute("rams", ramService.findAll());
            model.addAttribute("boards", boardService.findAll());
            model.addAttribute("powersupplis", powerSupplyService.findAll());
            model.addAttribute("coolingsystems", coolingSystemService.findAll());
            model.addAttribute("casess", caseService.findAll());
            model.addAttribute("mainmemoris", mainMemoryService.findAll());
            model.addAttribute("graphiccards", graphicCardService.findAll());
            return "computer/new";
        }
        computerService.save(computer);
        return "redirect:/computer";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id,@ModelAttribute("cpus") CPU cpu, @ModelAttribute("rams") RAM ram,
                       @ModelAttribute("boards")Board board, @ModelAttribute("powersupplis")PowerSupply powerSupply, @ModelAttribute("coolingsystems") CoolingSystem coolingSystem,
                       @ModelAttribute("casess") Case cases, @ModelAttribute("mainmemoris") MainMemory mainMemory, @ModelAttribute("graphiccards") GraphicCard graphicCard) {
        model.addAttribute("computer", computerService.findOne(id));
        model.addAttribute("cpus", cpuService.findAll());
        model.addAttribute("rams", ramService.findAll());
        model.addAttribute("boards", boardService.findAll());
        model.addAttribute("powersupplis", powerSupplyService.findAll());
        model.addAttribute("coolingsystems", coolingSystemService.findAll());
        model.addAttribute("casess", caseService.findAll());
        model.addAttribute("mainmemoris", mainMemoryService.findAll());
        model.addAttribute("graphiccards", graphicCardService.findAll());

        return "computer/edit";
    }

    @PatchMapping("/{id}")
    public String update(Model model,@ModelAttribute("computer") @Valid Computer computer, BindingResult bindingResult, @PathVariable("id") int id, @ModelAttribute("cpus") CPU cpu, @ModelAttribute("rams") RAM ram,
                         @ModelAttribute("boards")Board board, @ModelAttribute("powersupplis")PowerSupply powerSupply, @ModelAttribute("coolingsystems") CoolingSystem coolingSystem,
                         @ModelAttribute("casess") Case cases, @ModelAttribute("mainmemoris") MainMemory mainMemory, @ModelAttribute("graphiccards") GraphicCard graphicCard) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("computer", computerService.findOne(id));
            model.addAttribute("cpus", cpuService.findAll());
            model.addAttribute("rams", ramService.findAll());
            model.addAttribute("boards", boardService.findAll());
            model.addAttribute("powersupplis", powerSupplyService.findAll());
            model.addAttribute("coolingsystems", coolingSystemService.findAll());
            model.addAttribute("casess", caseService.findAll());
            model.addAttribute("mainmemoris", mainMemoryService.findAll());
            model.addAttribute("graphiccards", graphicCardService.findAll());
            return "computer/edit";
        }
        computerService.update(id, computer);
        return "redirect:/computer";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        computerService.delete(id);
        return "redirect:/computer";
    }

}

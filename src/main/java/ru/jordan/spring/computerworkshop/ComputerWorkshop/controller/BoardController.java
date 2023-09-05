package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Board;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.services.BoardService;

import javax.validation.Valid;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;


    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("boards", boardService.findAll());
        return "board/all";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("board", boardService.findOne(id));
        return "board/show";
    }

    @GetMapping("/new")
    public String newBoard(@ModelAttribute("board") Board board) {
        return "board/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("board") @Valid Board board, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "board/new";
        }
        boardService.save(board);
        return "redirect:/board";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("board", boardService.findOne(id));
        return "board/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("board") @Valid Board board, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "board/edit";
        }
        boardService.update(id, board);
        return "redirect:/board";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        boardService.delete(id);
        return "redirect:/board";
    }


}

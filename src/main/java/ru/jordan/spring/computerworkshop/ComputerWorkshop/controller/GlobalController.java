package ru.jordan.spring.computerworkshop.ComputerWorkshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/global")
public class GlobalController {


    @GetMapping()
    public String global(){
        return "global/global";
    }

}

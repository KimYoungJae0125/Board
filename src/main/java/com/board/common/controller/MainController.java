package com.board.common.controller;

import com.board.common.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/index")
    public String index(Model model) {

        model.addAttribute("products", mainService.selectList());
        model.addAttribute("title", "Thymeleaf Test");

        return "/index";
    }

}

package com.board.products.controller;

import com.board.products.service.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductsFormController {

    private final String TEMPLATE_PREFIX = "/views/products";

    private final ProductsService productsService;

    @GetMapping
    public String findAllProducts(Model model) {

        model.addAttribute("products", productsService.findAllProducts());
        model.addAttribute("title", "Thymeleaf Test");

        return TEMPLATE_PREFIX + "/list";
    }
}

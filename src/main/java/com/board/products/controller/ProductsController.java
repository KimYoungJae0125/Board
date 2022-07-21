package com.board.products.controller;

import com.board.products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public String getProductsList(Model model) {

        model.addAttribute("products", productsService.getProductList());
        model.addAttribute("title", "Thymeleaf Test");

        return "/products/list";
    }

    @GetMapping("/view")
    public String getProduct(Model model, String prodId) {

        model.addAttribute("product", productsService.getProduct(prodId));
        model.addAttribute("title", "Thymeleaf Test");

        return "/products/view";
    }

}

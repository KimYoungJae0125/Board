package com.board.products.controller;

import com.board.products.model.dto.Products;
import com.board.products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public String getProducts(Model model) {

        model.addAttribute("products", productsService.getProducts());
        model.addAttribute("title", "Thymeleaf Test");

        return "/products/list";
    }

    @PostMapping
    @ResponseBody
    public void insertProduct(@RequestBody Products products) {

        productsService.insertProduct(products);

    }

    @GetMapping("/view")
    public String viewProduct(Model model, String prodId) {

        model.addAttribute("product", productsService.viewProduct(prodId));
        model.addAttribute("title", "Thymeleaf Test");

        return "/products/view";
    }
    @GetMapping("/write")
    public String writeProduct() {

        return "/products/write";
    }

}

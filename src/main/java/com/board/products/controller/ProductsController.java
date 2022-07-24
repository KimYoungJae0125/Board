package com.board.products.controller;

import com.board.common.response.ResponseMessage;
import com.board.products.model.dto.ProductsRequestDto;
import com.board.products.model.validator.ProductsValidator;
import com.board.products.service.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductsController {

    private final ProductsService productsService;

    private final ProductsValidator productsValidator;

    @InitBinder("ProductsRequestDto")
    public void addProductsValidator(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(productsValidator);
    }

    @GetMapping
    public String getProducts(Model model) {

        model.addAttribute("products", productsService.getProducts());
        model.addAttribute("title", "Thymeleaf Test");

        return "/products/list";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity insertProduct(@RequestBody @Valid ProductsRequestDto ProductsRequestDto) {

        productsService.insertProduct(ProductsRequestDto);


        return ResponseEntity.ok().body(ResponseMessage.OK(200, "", "", ProductsRequestDto));
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

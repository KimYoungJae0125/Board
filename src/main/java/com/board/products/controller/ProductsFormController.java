package com.board.products.controller;

import com.board.common.response.ResponseMessage;
import com.board.products.model.dto.ProductsRequestDto;
import com.board.products.model.validator.ProductsValidator;
import com.board.products.service.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

    private final String TEMPLATE_PREFIX = "/views/products";

    private final ProductsService productsService;

    @GetMapping
    public String getProducts(Model model) {

        model.addAttribute("products", productsService.getProducts());
        model.addAttribute("title", "Thymeleaf Test");

        return TEMPLATE_PREFIX + "/list";
    }

    @GetMapping("/{prodId}")
    public String viewProduct(Model model, @PathVariable String prodId) {

        model.addAttribute("product", productsService.viewProduct(prodId));
        model.addAttribute("title", "Thymeleaf Test");

        return TEMPLATE_PREFIX + "/view";
    }

    @GetMapping("/write")
    public String writeProduct() {

        return TEMPLATE_PREFIX + "/write";
    }

    private final ProductsValidator productsValidator;

    @InitBinder("productsRequestDto")
    public void addProductsValidator(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(productsValidator);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity insertProduct(@RequestBody @Valid ProductsRequestDto ProductsRequestDto) {
        productsService.insertProduct(ProductsRequestDto);
        return ResponseEntity.ok().body(ResponseMessage.OK(200, HttpStatus.OK.getReasonPhrase(), "상품 등록에 성공하셨습니다.", ProductsRequestDto));
    }
    @DeleteMapping("/{prodId}")
    @ResponseBody
    public ResponseEntity deleteProduct(@PathVariable String prodId) {
        productsService.deleteProduct(prodId);
        return ResponseEntity.ok().body(ResponseMessage.OK(200, HttpStatus.OK.getReasonPhrase(), "상품 삭제에 성공하셨습니다."));
    }
    @PatchMapping("/{prodId}")
    @ResponseBody
    public ResponseEntity updateProduct(@PathVariable String prodId) {
        return null;
    }

    @PutMapping("/{prodId}")
    @ResponseBody
    public ResponseEntity updateAllProduct(@PathVariable String prodId) {
        return null;
    }

}

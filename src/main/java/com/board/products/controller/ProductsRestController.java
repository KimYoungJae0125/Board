package com.board.products.controller;

import com.board.common.response.ResponseMessage;
import com.board.products.model.dto.ProductsRequestDto;
import com.board.products.model.validator.ProductsValidator;
import com.board.products.service.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductsRestController {

    private final ProductsService productsService;
    private final ProductsValidator productsValidator;

    @InitBinder("productsRequestDto")
    public void addProductsValidator(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(productsValidator);
    }

    @GetMapping("/{productId}")
    public ResponseEntity findProduct(@PathVariable Long productId) {

        return ResponseMessage.SUCCESS("상품 조회에 성공하였습니다.", productsService.findProduct(productId));
    }

    @PostMapping
    public ResponseEntity insertProduct(@RequestBody @Valid ProductsRequestDto productsRequestDto) {
        return ResponseMessage.SUCCESS("상품 등록에 성공하였습니다.", productsService.insertProduct(productsRequestDto));
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Long productId) {
        productsService.deleteProduct(productId);
        return ResponseMessage.SUCCESS("상품 삭제에 성공하였습니다.");
    }
    @PatchMapping("/{productId}")
    public ResponseEntity updateProduct(@PathVariable Long productId, @RequestBody ProductsRequestDto productsRequestDto) {
        productsRequestDto.setProductId(productId);
        return ResponseMessage.SUCCESS("상품 정보 수정에 성공하였습니다.", productsService.updateProduct(productsRequestDto));
    }

    @PutMapping("/{productId}")
    public ResponseEntity updateAllProduct(@PathVariable String productId) {
        return null;
    }

}

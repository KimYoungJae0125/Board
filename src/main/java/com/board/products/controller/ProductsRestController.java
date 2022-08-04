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

    @PostMapping
    public ResponseEntity insertProduct(@RequestBody @Valid ProductsRequestDto productsRequestDto) {
        productsService.insertProduct(productsRequestDto);
        return ResponseEntity.ok().body(ResponseMessage.OK(200, HttpStatus.OK.getReasonPhrase(), "상품 등록에 성공하셨습니다.", productsRequestDto));
    }
    @DeleteMapping("/{prodId}")
    public ResponseEntity deleteProduct(@PathVariable Long prodId) {
        productsService.deleteProduct(prodId);
        return ResponseEntity.ok().body(ResponseMessage.OK(200, HttpStatus.OK.getReasonPhrase(), "상품 삭제에 성공하셨습니다."));
    }
    @PatchMapping("/{prodId}")
    public ResponseEntity updateProduct(@PathVariable Long prodId, @RequestBody ProductsRequestDto productsRequestDto) {
        productsRequestDto.setProductId(prodId);

        return ResponseEntity.ok().body(ResponseMessage.OK(200, HttpStatus.OK.getReasonPhrase(), "상품 정보 수정에 성공하셨습니다.", productsService.updateProduct(productsRequestDto)));
    }

    @PutMapping("/{prodId}")
    public ResponseEntity updateAllProduct(@PathVariable String prodId) {
        return null;
    }

}

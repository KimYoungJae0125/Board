package com.board.products.service;

import com.board.products.model.dao.ProductsDao;
import com.board.products.model.dto.ProductsRequestDto;
import com.board.products.model.dto.ProductsResponseDto;
import com.board.products.model.entity.Products;
import com.board.products.model.mapper.ProductsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsDao productsDao;

    private final ProductsMapper productsMapper;

    public List<ProductsResponseDto> getProducts() {
        return productsMapper.entityListToDtoList(productsDao.getProducts());
    }

    public ProductsResponseDto viewProduct(String prodId) {
        return productsMapper.entityToDto(productsDao.viewProduct(prodId));
    }

    public void insertProduct(ProductsRequestDto ProductsRequestDto) {
        Products products = productsMapper.dtoToEntity(ProductsRequestDto);

        productsDao.insertProduct(products);
    }
}

package com.board.products.model.dao;

import com.board.products.model.entity.Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductsDao {

    public List<Products> getProducts();

    public Products viewProduct(Long id);


    public Long insertProduct(Products products);

    void deleteProduct(Long id);

    void updateProduct(Products productsRequestDto);
}

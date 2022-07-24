package com.board.products.model.dao;

import com.board.products.model.entity.Products;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductsDao {

    public List<Products> getProducts();

    public Products viewProduct(String id);


    void insertProduct(Products products);
}

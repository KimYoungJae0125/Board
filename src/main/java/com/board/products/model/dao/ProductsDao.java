package com.board.products.model.dao;

import com.board.products.model.dto.Products;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductsDao {

    public List<Products> getProductList();

    public Products getProduct(String prodId);


}

package com.board.products.service;

import com.board.products.model.dao.ProductsDao;
import com.board.products.model.dto.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductsDao productsDao;

    public List<Products> getProductList() {
        return productsDao.getProductList();
    }

    public Products getProduct(String prodId) {
        return productsDao.getProduct(prodId);
    }

}

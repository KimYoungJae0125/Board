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

    public ProductsResponseDto viewProduct(Long prodId) {
        return productsMapper.entityToDto(productsDao.viewProduct(prodId));
    }

    public ProductsResponseDto insertProduct(ProductsRequestDto ProductsRequestDto) {
        Products products = productsMapper.dtoToEntity(ProductsRequestDto);

        //MyBatis에서 insert 태그에 useGeneratedKeys="true" keyProperty="id" 설정을 할 경우 Auto_Increment(MySQL 기준)로 추가 된 id가 자동으로 model에 저장이 된다.
        //해당 id를 불러오려면 model_클래스.getId()를 하면 된다.(밑에 products.Dao.insertProduct(products)의 리턴값은 새로 추가 된 행의 개수이기 때문에 id 값을 가져오지 못한다.)
        productsDao.insertProduct(products);

        return viewProduct(products.getId());
    }

    public void deleteProduct(Long prodId) {
        productsDao.deleteProduct(prodId);
    }

    public ProductsResponseDto updateProduct(ProductsRequestDto productsRequestDto) {
        productsDao.updateProduct(productsMapper.updateDtoToEntity(productsRequestDto));
        return viewProduct(productsRequestDto.getProductId());
    }
}

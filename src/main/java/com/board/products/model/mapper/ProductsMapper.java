package com.board.products.model.mapper;

import com.board.products.model.dto.ProductsRequestDto;
import com.board.products.model.dto.ProductsResponseDto;
import com.board.products.model.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductsMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "prodName")
    @Mapping(target = "price", source = "prodPrice")
    Products dtoToEntity(ProductsRequestDto ProductsRequestDto);

    @Mapping(target = "prodId", source = "id")
    @Mapping(target = "prodName", source = "name")
    @Mapping(target = "prodPrice", source = "price")
    ProductsResponseDto entityToDto(Products products);
    List<ProductsResponseDto> entityListToDtoList(List<Products> products);

}

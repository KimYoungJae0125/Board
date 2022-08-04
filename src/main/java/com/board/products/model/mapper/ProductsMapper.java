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
    @Mapping(target = "name", source = "productName")
    @Mapping(target = "price", source = "productPrice")
    @Mapping(target = "content", source = "productContent")
    @Mapping(target = "writer", source = "productWriter")
    @Mapping(target = "creationTime", source = "productCreationTime")
    Products dtoToEntity(ProductsRequestDto ProductsRequestDto);

    @Mapping(target = "id", source = "productId")
    @Mapping(target = "name", source = "productName")
    @Mapping(target = "price", source = "productPrice")
    @Mapping(target = "content", source = "productContent")
    @Mapping(target = "writer", ignore = true)
    @Mapping(target = "creationTime", ignore = true)
    Products updateDtoToEntity(ProductsRequestDto ProductsRequestDto);

    ProductsResponseDto entityToDto(Products products);
    List<ProductsResponseDto> entityListToDtoList(List<Products> products);

}

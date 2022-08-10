package com.board.products.model.mapper;

import com.board.products.model.dto.ProductsRequestDto;
import com.board.products.model.dto.ProductsResponseDto;
import com.board.products.model.entity.Products;
import com.board.users.model.entity.Users;
import com.board.users.model.mapper.UsersMapper;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = UsersMapper.class)
public interface ProductsMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "productName")
    @Mapping(target = "price", source = "productPrice")
    @Mapping(target = "content", source = "productContent")
    @Mapping(target = "users.id", source = "productWriter.userId")
    @Mapping(target = "users.name", ignore = true)
    @Mapping(target = "creationTime", source = "productCreationTime")
    Products dtoToEntity(ProductsRequestDto ProductsRequestDto);

    @Mapping(target = "id", source = "productId")
    @Mapping(target = "name", source = "productName")
    @Mapping(target = "price", source = "productPrice")
    @Mapping(target = "content", source = "productContent")
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "creationTime", ignore = true)
    Products updateDtoToEntity(ProductsRequestDto ProductsRequestDto);

    @Mapping(target = "writer.id", source = "users.id")
    @Mapping(target = "writer.name", source = "users.name")

    ProductsResponseDto entityToDto(Products products);
    List<ProductsResponseDto> entityListToDtoList(List<Products> products);

}

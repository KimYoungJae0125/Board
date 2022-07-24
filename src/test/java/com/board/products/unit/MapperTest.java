package com.board.products.unit;

import com.board.products.model.dto.ProductsRequestDto;
import com.board.products.model.dto.ProductsResponseDto;
import com.board.products.model.entity.Products;
import com.board.products.model.mapper.ProductsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;



@SpringBootTest
public class MapperTest {

    @Autowired
    ProductsMapper productsMapper;


    @Test
    void dtoToEntityTest() throws Exception {

        ProductsRequestDto productsRequestDto = ProductsRequestDto.builder()
                                .prodName("tets")
                                .prodPrice(123L)
                                .build();

        Products products = productsMapper.dtoToEntity(productsRequestDto);

        assertThat(products.getName(), is(productsRequestDto.getProdName()));
        assertThat(products.getPrice(), is(productsRequestDto.getProdPrice()));

    }
    @Test
    void entityListToDtoListTest() throws Exception {

        List<Products> products = new ArrayList<>();

        for(int i=1; i<=10; i++) {
            Products product = Products.builder()
                                    .id(Long.valueOf(i))
                                    .name("tets" + i)
                                    .price(123L)
                                    .build();

            products.add(product);

        }

        List<ProductsResponseDto> productsResponseDtos = productsMapper.entityListToDtoList(products);

        for(int i = 0, len = productsResponseDtos.size(); i<len; i++) {
            assertThat(products.get(i).getName(), is(productsResponseDtos.get(i).getProdName()));
            assertThat(products.get(i).getId(), is(productsResponseDtos.get(i).getProdId()));
            assertThat(products.get(i).getPrice(), is(productsResponseDtos.get(i).getProdPrice()));
        }




    }



}

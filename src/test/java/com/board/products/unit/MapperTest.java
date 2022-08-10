//package com.board.products.unit;
//
//import Users;
//import com.board.products.model.dto.ProductsRequestDto;
//import com.board.products.model.dto.ProductsResponseDto;
//import com.board.products.model.entity.Products;
//import com.board.products.model.mapper.ProductsMapper;
//import com.board.products.model.mapper.ProductsMapperImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//public class MapperTest {
//
//    ProductsMapper productsMapper;
//
//    @BeforeEach
//    void setUp() {
//        productsMapper = new ProductsMapperImpl();
//    }
//
//    @Test
//    @DisplayName("Dto -> Entity로 매핑")
//    void dtoToEntityTest() throws Exception {
//
//        LocalDateTime now = LocalDateTime.now();
//
//        ProductsRequestDto productsRequestDto = ProductsRequestDto.builder()
//                                .productName("상품 이름")
//                                .productPrice(123L)
//                                .productContent("상품 내용")
//                                .productWriter(Users.builder().id(1L).build())
//                                .productCreationTime(now)
//                                .build();
//
//        Products products = productsMapper.dtoToEntity(productsRequestDto);
//
//        assertThat(products.getName(), is("상품 이름"));
//        assertThat(products.getPrice(), is(123L));
//        assertThat(products.getContent(), is("상품 내용"));
//        assertThat(products.getWriter(), is("tester"));
//        assertThat(products.getCreationTime(), is(now));
//
//    }
//    @Test
//    @DisplayName(" Entity -> Dto로 매핑")
//    void entityListToDtoListTest() throws Exception {
//
//        List<Products> products = new ArrayList<>();
//
//        for(int i=0; i<10; i++) {
//            Products product = Products.builder()
//                                    .id(Long.valueOf(i+1))
//                                    .name("상품 이름" + i)
//                                    .price(123L)
//                                    .build();
//
//            products.add(product);
//
//        }
//
//        List<ProductsResponseDto> productsResponseDtos = productsMapper.entityListToDtoList(products);
//
//        for(int i = 0, len = productsResponseDtos.size(); i<len; i++) {
//            assertThat(products.get(i).getId(), is(i+1L));
//            assertThat(products.get(i).getName(), is("상품 이름" + i));
//            assertThat(products.get(i).getPrice(), is(123L));
//        }
//
//
//
//
//    }
//
//
//
//}

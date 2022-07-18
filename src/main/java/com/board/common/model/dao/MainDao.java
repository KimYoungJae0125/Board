package com.board.common.model.dao;

import com.board.common.model.dto.Products;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MainDao {

    public List<Products> selectList();

}

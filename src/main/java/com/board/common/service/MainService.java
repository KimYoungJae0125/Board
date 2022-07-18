package com.board.common.service;

import com.board.common.model.dao.MainDao;
import com.board.common.model.dto.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private MainDao mainDao;

    public List<Products> selectList() {
        return mainDao.selectList();
    }

}

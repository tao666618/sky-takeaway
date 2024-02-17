package com.sky.service;

import com.sky.dto.DishDTO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品相关接口")
//@Slf4j
public interface DishService {



    /**
     * 菜品味道
     *
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);

















}

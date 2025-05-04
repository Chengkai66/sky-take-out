package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetmealService {
    void saveSetmeal(SetmealDTO setmealDTO);

    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    void deleteSetmealByIds(List<Long> ids);

    SetmealVO getSetmealById(Long id);

    void updateSetmealWithDish(SetmealDTO setmealDTO);

    void updateStatus(Integer status, Long id);
}

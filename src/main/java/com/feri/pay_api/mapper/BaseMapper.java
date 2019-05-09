package com.feri.pay_api.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/5/8 14:36
 */
public interface BaseMapper<T> {
    long selectCount();
    List<T> selectByPage(@Param("index")int index,@Param("count") int count);
}

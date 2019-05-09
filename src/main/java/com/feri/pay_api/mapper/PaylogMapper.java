package com.feri.pay_api.mapper;

import com.feri.pay_api.entity.Paylog;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Feri
 * @since 2019-05-08
 */
public interface PaylogMapper extends BaseMapper<Paylog>{
    int save(Paylog paylog);
    //单条查询
    Paylog selectSingle(int id);

}

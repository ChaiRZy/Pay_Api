package com.feri.pay_api.mapper;

import com.feri.pay_api.entity.Paylog;
import com.feri.pay_api.entity.Prepayment;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Feri
 * @since 2019-05-08
 */
public interface PrepaymentMapper extends BaseMapper<Prepayment>{
    int save(Prepayment prepayment);
    Prepayment selectSingle(int id);
}

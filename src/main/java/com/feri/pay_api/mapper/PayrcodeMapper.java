package com.feri.pay_api.mapper;

import com.feri.pay_api.entity.Paylog;
import com.feri.pay_api.entity.Payrcode;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Feri
 * @since 2019-05-08
 */
public interface PayrcodeMapper extends BaseMapper<Payrcode>{
    int save(Payrcode payrcode);
    Payrcode selectSingle(int id);

}

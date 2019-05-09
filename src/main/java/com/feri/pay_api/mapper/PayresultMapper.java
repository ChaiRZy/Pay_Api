package com.feri.pay_api.mapper;

import com.feri.pay_api.entity.Paylog;
import com.feri.pay_api.entity.Payresult;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Feri
 * @since 2019-05-08
 */
public interface PayresultMapper extends BaseMapper<Payresult> {

    int save(Payresult payresult);

    int updateFlag(@Param("oid") String oid, @Param("flag") int flag);
    Payresult selectSingle(String oid);

}

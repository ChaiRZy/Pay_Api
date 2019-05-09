package com.feri.pay_api.service;

import com.feri.pay_api.entity.Payrcode;
import com.feri.pay_api.entity.Payresult;
import com.feri.pay_api.vo.ResultVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Feri
 * @since 2019-05-08
 */
public interface PayresultService {
    ResultVO save(Payresult payresult);
    //单条查询
    ResultVO selectSingle(String oid);
    ResultVO updateFlag(String oid,int flag);
    ResultVO selectPage(int page,int count);
}

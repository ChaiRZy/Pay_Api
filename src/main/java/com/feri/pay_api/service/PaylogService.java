package com.feri.pay_api.service;

import com.feri.pay_api.entity.Paylog;
import com.feri.pay_api.vo.ResultVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Feri
 * @since 2019-05-08
 */
public interface PaylogService {
    ResultVO save(Paylog paylog);
    //单条查询
    ResultVO selectSingle(int id);
    ResultVO selectPage(int page,int count);

}

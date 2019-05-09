package com.feri.pay_api.pay.service;

import com.feri.pay_api.pay.entity.WxchatOrder;
import com.feri.pay_api.vo.ResultVO;

/**
 *@Author feri
 *@Date Created in 2019/5/8 15:47
 */
public interface WxchatPayService {
    //统一下单 获取预支付链接
    ResultVO preOrder(WxchatOrder order);
    //查询订单
    ResultVO queryOrder(String oid);

}

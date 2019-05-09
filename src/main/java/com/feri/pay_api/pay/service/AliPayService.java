package com.feri.pay_api.pay.service;

import com.alipay.api.AlipayApiException;
import com.feri.pay_api.pay.entity.AliPayOrder;
import com.feri.pay_api.vo.ResultVO;

/**
 *@Author feri
 *@Date Created in 2019/5/8 17:05
 */
public interface AliPayService {
    ResultVO preOrder(AliPayOrder order) throws AlipayApiException;
    ResultVO searchOrder(String oid) throws AlipayApiException;
}

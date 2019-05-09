package com.feri.pay_api.pay.entity;

import lombok.Data;

/**
 *@Author feri
 *@Date Created in 2019/5/8 16:54
 */
@Data
public class AliPayOrder {
    private String out_trade_no;//订单编号
    private double total_amount;//订单金额
    private String subject;//商品描述

}

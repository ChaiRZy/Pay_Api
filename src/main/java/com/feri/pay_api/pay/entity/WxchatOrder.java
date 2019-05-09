package com.feri.pay_api.pay.entity;

import lombok.Data;

/**
 *@Author feri
 *@Date Created in 2019/5/8 15:49
 */
@Data
public class WxchatOrder {
    private String body;//商品描述
    private String out_trade_no;//订单号
    private int total_fee;//金额 单位分
    private String spbill_create_ip;//终端ip

}

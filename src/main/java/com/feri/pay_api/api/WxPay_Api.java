package com.feri.pay_api.api;

import com.feri.pay_api.pay.entity.WxchatOrder;
import com.feri.pay_api.pay.service.WxchatPayService;
import com.feri.pay_api.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/5/8 16:08
 */
@Api(value = "微信支付相关操作",tags = "微信支付相关操作")
@RestController
public class WxPay_Api {
    @Autowired
    private WxchatPayService payService;

    @ApiOperation(value = "微信支付",notes = "微信的预支付操作")
    @PostMapping("/pay/wxpay/preoder.do")
    public ResultVO pay(@RequestBody WxchatOrder order){
        return payService.preOrder(order);
    }
    @ApiOperation(value = "微信支付查询",notes = "查询微信支付的订单状态")
    @GetMapping("/pay/wxpay/searchorder.do")
    public ResultVO search(String oid){
        return payService.queryOrder(oid);
    }
}

package com.feri.pay_api.api;

import com.alipay.api.AlipayApiException;
import com.feri.pay_api.pay.entity.AliPayOrder;
import com.feri.pay_api.pay.service.AliPayService;
import com.feri.pay_api.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 *@Author feri
 *@Date Created in 2019/5/8 17:10
 */
@Api(value = "支付宝支付操作",tags = "支付宝相关操作")
@RestController
public class AliPay_Api {
    @Autowired
    private AliPayService aliPayService;
    @ApiOperation(value = "生成预支付信息",notes = "支付宝支付的预支付信息")
    @PostMapping("/pay/alipay/createorder.do")
    public ResultVO createOrder(@RequestBody AliPayOrder order) throws AlipayApiException {
        return aliPayService.preOrder(order);
    }
    @ApiOperation(value = "查询支付宝支付结果",notes = "查询支付宝支付结果")
    @GetMapping("/pay/alipay/searchorder.do")
    public ResultVO createOrder(String oid, HttpServletRequest request) throws AlipayApiException {
        //request.getServletContext().getRealPath("");
        return aliPayService.searchOrder(oid);
    }
}
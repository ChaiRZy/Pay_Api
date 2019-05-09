package com.feri.pay_api.pay.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.feri.pay_api.pay.entity.AliPayOrder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@Author feri
 *@Date Created in 2019/5/8 16:44
 */
public class AliPayUtil {
    private AlipayClient alipayClient;
    public AliPayUtil(String appid,String appPrivateKey,String appPublicKey){
        alipayClient=new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",appid,appPrivateKey,"json",
                "UTF-8",appPublicKey,"RSA2");
    }

    //下单获取支付页面
    public void preOrder(AliPayOrder order,HttpServletResponse response) throws IOException {
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent(JSON.toJSONString(order));//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(form);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }
    //生成预支付链接
    public String preOrder2(AliPayOrder order) throws AlipayApiException {
        order.setTotal_amount(0.01);
        AlipayTradePrecreateRequest request=new AlipayTradePrecreateRequest();
        request.setBizContent(JSON.toJSONString(order));
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        System.out.println(response.getBody());
        if(response.isSuccess()){
            return response.getQrCode();
        } else {
           return null;
        }
    }
    //订单查询
    public String searchOrder(String oid) throws AlipayApiException {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{\"out_trade_no\":\""+oid+"\"}");
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        if(response.isSuccess()) {
            return response.getTradeStatus();
        }else {
            return null;
        }
    }
}

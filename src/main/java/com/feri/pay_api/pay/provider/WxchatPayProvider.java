package com.feri.pay_api.pay.provider;

import com.feri.pay_api.entity.Paylog;
import com.feri.pay_api.entity.Payrcode;
import com.feri.pay_api.entity.Payresult;
import com.feri.pay_api.entity.Prepayment;
import com.feri.pay_api.pay.dbservice.DbService;
import com.feri.pay_api.pay.entity.WxchatOrder;
import com.feri.pay_api.pay.service.WxchatPayService;
import com.feri.pay_api.pay.wxchat.WxChatPayUtil;
import com.feri.pay_api.util.Base64Util;
import com.feri.pay_api.util.ResultUtil;
import com.feri.pay_api.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2019/5/8 15:52
 */
@Service
public class WxchatPayProvider implements WxchatPayService {

    @Autowired
    private WxChatPayUtil wxChatPayUtil;
    @Autowired
    private DbService dbService;
    @Override
    @Transactional
    public ResultVO preOrder(WxchatOrder order) {
        order.setTotal_fee(1);//仅供测试
        Map<String,String> map=new HashMap<>();
        map.put("body",order.getBody());
        map.put("out_trade_no",order.getOut_trade_no());
        map.put("spbill_create_ip",order.getSpbill_create_ip());
        map.put("total_fee",order.getTotal_fee()+"");
        map.put("notify_url","http://localhost:8081/payresult");
        Map<String,String> result=wxChatPayUtil.createOrder(map);
        System.out.println(result);
        if(result.containsKey("code_url")){
            String codeurl=result.get("code_url");
            dbService.getPaylogService().save(new Paylog(order.getOut_trade_no(),"支付宝预支付："+codeurl,1));
            Prepayment prepayment=new Prepayment(order.getOut_trade_no(),1,(int)(order.getTotal_fee()),codeurl);
            dbService.getPrepaymentService().save(prepayment);
            dbService.getPayrcodeService().save(
                    new Payrcode(prepayment.getId(),"http://localhost:8081/qrcode/createqrcodeconvert.do?msg="+Base64Util.base64Enc(codeurl.getBytes()),2));
            dbService.getPayresultService().save(new Payresult(order.getOut_trade_no(),1));

            //预支付成功
            return ResultUtil.setOK("请求成功，请扫码支付",
                    "http://localhost:8081/qrcode/createqrcodeconvert.do?msg="+Base64Util.base64Enc(codeurl.getBytes()));
        }else {
            return ResultUtil.setERROR();
        }
    }

    @Override
    @Transactional
    public ResultVO queryOrder(String oid) {
        Map<String,String> result=wxChatPayUtil.searchOrder(oid);
        if(result.containsKey("trade_state")){
            String msg="";
            int flag=3;
            String r=result.get("trade_state");
            switch (r){
                case "SUCCESS":
                    msg="支付成功";
                    flag=2;
                    break;
                case "CLOSED":
                    msg="支付失效";
                    break;
                case "USERPAYING":
                    msg="用户支付中";
                    break;
                    default:
                        msg="支付失败";
                        break;
            }
            ResultVO resultVO=dbService.getPayresultService().selectSingle(oid);
            Payresult payresult= (Payresult) resultVO.getData();
            if(payresult.getFlag()==1){
                dbService.getPayresultService().updateFlag(oid,flag);
                dbService.getPaylogService().save(new Paylog(oid,"订单支付成功",4));
            }
            dbService.getPaylogService().save(new Paylog(oid,"查询订单支付状态：成功，结果："+r,5));
            return ResultUtil.setOK(msg);
        }else {
            dbService.getPaylogService().save(new Paylog(oid,"查询订单支付状态：失败，异常",5));
            return ResultUtil.setERROR();
        }
    }
}

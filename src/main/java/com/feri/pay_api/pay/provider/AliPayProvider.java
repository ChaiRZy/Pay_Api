package com.feri.pay_api.pay.provider;

import com.alipay.api.AlipayApiException;
import com.feri.pay_api.entity.Paylog;
import com.feri.pay_api.entity.Payrcode;
import com.feri.pay_api.entity.Payresult;
import com.feri.pay_api.entity.Prepayment;
import com.feri.pay_api.pay.alipay.AliPayUtil;
import com.feri.pay_api.pay.dbservice.DbService;
import com.feri.pay_api.pay.entity.AliPayOrder;
import com.feri.pay_api.pay.service.AliPayService;
import com.feri.pay_api.service.PayrcodeService;
import com.feri.pay_api.service.PrepaymentService;
import com.feri.pay_api.util.Base64Util;
import com.feri.pay_api.util.ResultUtil;
import com.feri.pay_api.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *@Author feri
 *@Date Created in 2019/5/8 17:06
 */
@Service
public class AliPayProvider implements AliPayService {
    @Autowired
    private AliPayUtil aliPayUtil;

    @Autowired
    private DbService dbService;

    @Override
    @Transactional
    public ResultVO preOrder(AliPayOrder order) throws AlipayApiException {
        String codeurl=aliPayUtil.preOrder2(order);
        if(codeurl!=null){

            dbService.getPaylogService().save(new Paylog(order.getOut_trade_no(),"支付宝预支付："+codeurl,1));
            Prepayment prepayment=new Prepayment(order.getOut_trade_no(),1,(int)(order.getTotal_amount()*100),codeurl);
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
    public ResultVO searchOrder(String oid) throws AlipayApiException {
        String r=aliPayUtil.searchOrder(oid);
        if(r!=null) {
            String msg = "";
            int flag=3;
            switch (r) {
                case "WAIT_BUYER_PAY":
                    msg = "交易创建，等待买家付款";
                    break;
                case "TRADE_CLOSED":
                    msg = "未付款交易超时关闭，或支付完成后全额退款";
                    break;
                case "TRADE_SUCCESS":
                    msg = "支付成功";
                    flag=2;
                    break;
                case "TRADE_FINISHED":
                    msg = "交易结束，不可退款";
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

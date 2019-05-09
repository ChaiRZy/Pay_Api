package com.feri.pay_api.zxing;

import com.feri.pay_api.vo.ResultVO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@Author feri
 *@Date Created in 2019/5/8 15:04
 */
public interface QrCodeService {
    //生成二维码，在线显示
    void createQrcode(String msg,HttpServletResponse response) throws IOException;
    //生成二维码，并将二维码转为base64格式
    ResultVO createQrCodeStr(String msg) throws IOException;
}

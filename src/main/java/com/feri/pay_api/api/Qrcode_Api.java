package com.feri.pay_api.api;

import com.feri.pay_api.util.Base64Util;
import com.feri.pay_api.vo.ResultVO;
import com.feri.pay_api.zxing.QrCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@Author feri
 *@Date Created in 2019/5/8 15:03
 */
@Controller
@Api(value = "操作二维码",tags = "操作二维码")
public class Qrcode_Api {

    @Autowired
    private QrCodeService qrCodeService;

    @ApiOperation(value = "生成二维码",notes = "生成二维码")
    @GetMapping("qrcode/createqrcode.do")
    public void create(String msg,HttpServletResponse response) throws IOException {
        qrCodeService.createQrcode(msg,response);
    }
    //如果要生成的内容包含网址 无法通过get传输 需要转码为base64
    @ApiOperation(value = "生成二维码",notes = "生成二维码,参数为base64格式")
    @GetMapping("qrcode/createqrcodeconvert.do")
    public void create3(String msg,HttpServletResponse response) throws IOException {

        qrCodeService.createQrcode(new String(Base64Util.base64Dec(msg)),response);
    }
    @ApiOperation(value = "生成二维码Base64格式",notes = "生成二维码Base64格式")
    @GetMapping("qrcode/createbase64.do")
    @ResponseBody
    public ResultVO create2(String msg, HttpServletResponse response) throws IOException {
        return qrCodeService.createQrCodeStr(msg);
    }
}

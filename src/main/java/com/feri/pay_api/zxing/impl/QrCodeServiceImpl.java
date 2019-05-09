package com.feri.pay_api.zxing.impl;

import com.feri.pay_api.util.Base64Util;
import com.feri.pay_api.util.ResultUtil;
import com.feri.pay_api.util.ZxingUtil;
import com.feri.pay_api.vo.ResultVO;
import com.feri.pay_api.zxing.QrCodeService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *@Author feri
 *@Date Created in 2019/5/8 15:06
 */
@Service
public class QrCodeServiceImpl implements QrCodeService {
    @Override
    public void createQrcode(String msg, HttpServletResponse response) throws IOException {
        BufferedImage bufferedImage=ZxingUtil.createImage(msg,400,400);
        ImageIO.write(bufferedImage,"JPEG",response.getOutputStream());
    }

    @Override
    public ResultVO createQrCodeStr(String msg) throws IOException {
        BufferedImage bufferedImage=ZxingUtil.createImage(msg,400,400);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ImageIO.write(bufferedImage,"JPEG",baos);
        return ResultUtil.setOK(Base64Util.base64Enc(baos.toByteArray()));
    }
}

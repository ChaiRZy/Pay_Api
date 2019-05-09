package com.feri.pay_api.config;

import com.feri.pay_api.pay.wxchat.WxChatPayUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author feri
 *@Date Created in 2019/5/8 15:53
 */
@Configuration
public class WxchatPayConfig {
    @Bean
    public WxChatPayUtil createWPU(){
        //参数说明：1、应用ID 2、商户id 3、秘钥
        return new WxChatPayUtil("wx632c8f211f8122c6","1497984412","sbNCm1JnevqI36LrEaxFwcaT0hkGxFnC","MD5");
    }
}

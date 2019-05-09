package com.feri.pay_api.entity;

import lombok.*;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Feri
 * @since 2019-05-08
 */
@Data
@NoArgsConstructor//无参构造
public class Paylog {
    private Integer id;
    private String oid;
    private String content;
    private Date createtime;
    private Integer flag;//1预支付信息 2二维码信息 4支付结果修改 5支付查询

    public Paylog(String oid, String content, Integer flag) {
        this.oid = oid;
        this.content = content;
        this.flag = flag;
    }
}
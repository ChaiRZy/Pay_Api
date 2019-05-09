package com.feri.pay_api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * <p>
 * 
 * </p>
 *
 * @author Feri
 * @since 2019-05-08
 */
@Data
@NoArgsConstructor
public class Prepayment{
    private Integer id;
    private String oid;
    private Integer type;
    private Integer money;
    private Integer result;
    private String qrcodeurl;
    private Date createtime;

    public Prepayment(String oid, Integer type, Integer money, String qrcodeurl) {
        this.oid = oid;
        this.type = type;
        this.money = money;
        this.qrcodeurl = qrcodeurl;
    }
}
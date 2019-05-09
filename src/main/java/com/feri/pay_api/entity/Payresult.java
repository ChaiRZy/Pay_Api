package com.feri.pay_api.entity;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Payresult  {
    private Integer id;
    private String oid;
    private Integer type;
    private Integer flag; //支付结果 1 未支付 2支付成功 3支付失败
    private Date createtime;
    private Date paytime;

    public Payresult(String oid, Integer type) {
        this.oid = oid;
        this.type = type;
    }
}
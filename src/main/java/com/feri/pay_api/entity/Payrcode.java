package com.feri.pay_api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
public class Payrcode  {

    private Integer id;
    private Integer poid;
    private String qrcode;
    private Integer hours;
    private Date createtime;
    private Integer flag;

    public Payrcode(Integer poid, String qrcode, Integer hours) {
        this.poid = poid;
        this.qrcode = qrcode;
        this.hours = hours;
    }
}

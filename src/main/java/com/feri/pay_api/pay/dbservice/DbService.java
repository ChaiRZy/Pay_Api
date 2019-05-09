package com.feri.pay_api.pay.dbservice;

import com.feri.pay_api.service.PaylogService;
import com.feri.pay_api.service.PayrcodeService;
import com.feri.pay_api.service.PayresultService;
import com.feri.pay_api.service.PrepaymentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2019/5/9 09:33
 */
@Data
@Service
public class DbService {
    @Autowired
    private PayrcodeService payrcodeService;
    @Autowired
    private PrepaymentService prepaymentService;
    @Autowired
    private PaylogService paylogService;
    @Autowired
    private PayresultService payresultService;

}

package com.feri.pay_api.provider;

import com.feri.pay_api.entity.Paylog;
import com.feri.pay_api.entity.Payrcode;
import com.feri.pay_api.mapper.PaylogMapper;
import com.feri.pay_api.mapper.PayrcodeMapper;
import com.feri.pay_api.service.PayrcodeService;
import com.feri.pay_api.service.PayresultService;
import com.feri.pay_api.util.ResultUtil;
import com.feri.pay_api.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2019/5/8 14:59
 */
@Service
public class PayRcodeServiceImpl implements PayrcodeService {
    @Autowired
    private PayrcodeMapper payrcodeMapper;
    @Override
    public ResultVO save(Payrcode payrcode) {
        return ResultUtil.exec(payrcodeMapper.save(payrcode)>0,"操作结束",null);
    }

    @Override
    public ResultVO selectSingle(int id) {
        return ResultUtil.setOK("OK",payrcodeMapper.selectSingle(id));
    }

    @Override
    public ResultVO selectPage(int page, int count) {

        return ResultUtil.setOK(payrcodeMapper.selectCount()+"",payrcodeMapper.selectByPage((page-1)*count,count));
    }
}

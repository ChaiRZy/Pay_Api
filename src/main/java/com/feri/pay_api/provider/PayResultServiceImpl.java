package com.feri.pay_api.provider;

import com.feri.pay_api.entity.Paylog;
import com.feri.pay_api.entity.Payresult;
import com.feri.pay_api.mapper.PaylogMapper;
import com.feri.pay_api.mapper.PayresultMapper;
import com.feri.pay_api.service.PayresultService;
import com.feri.pay_api.util.ResultUtil;
import com.feri.pay_api.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2019/5/8 14:57
 */
@Service
public class PayResultServiceImpl implements PayresultService {
    @Autowired
    private PayresultMapper payresultMapper;
    @Override
    public ResultVO save(Payresult payresult) {
        return ResultUtil.exec(payresultMapper.save(payresult)>0,"操作结束",null);
    }

    @Override
    public ResultVO selectSingle(String oid) {
        return ResultUtil.setOK("OK",payresultMapper.selectSingle(oid));
    }

    @Override
    public ResultVO updateFlag(String oid, int flag) {
        return  ResultUtil.exec(payresultMapper.updateFlag(oid, flag)>0,"操作结束",null);
    }

    @Override
    public ResultVO selectPage(int page, int count) {
        return ResultUtil.setOK(payresultMapper.selectCount()+"",payresultMapper.selectByPage((page-1)*count,count));
    }
}

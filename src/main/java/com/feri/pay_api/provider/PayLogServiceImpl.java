package com.feri.pay_api.provider;

import com.feri.pay_api.entity.Paylog;
import com.feri.pay_api.mapper.PaylogMapper;
import com.feri.pay_api.service.PaylogService;
import com.feri.pay_api.util.ResultUtil;
import com.feri.pay_api.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2019/5/8 14:54
 */
@Service
public class PayLogServiceImpl implements PaylogService {
    @Autowired
    private PaylogMapper paylogMapper;
    @Override
    public ResultVO save(Paylog paylog) {
        return ResultUtil.exec(paylogMapper.save(paylog)>0,"操作结束",null);
    }

    @Override
    public ResultVO selectSingle(int id) {
        return ResultUtil.setOK("OK",paylogMapper.selectSingle(id));
    }

    @Override
    public ResultVO selectPage(int page, int count) {

        return ResultUtil.setOK(paylogMapper.selectCount()+"",paylogMapper.selectByPage((page-1)*count,count));
    }
}

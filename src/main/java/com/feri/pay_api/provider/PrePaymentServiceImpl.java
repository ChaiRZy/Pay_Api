package com.feri.pay_api.provider;

import com.feri.pay_api.entity.Paylog;
import com.feri.pay_api.entity.Payrcode;
import com.feri.pay_api.entity.Prepayment;
import com.feri.pay_api.mapper.PrepaymentMapper;
import com.feri.pay_api.service.PrepaymentService;
import com.feri.pay_api.util.ResultUtil;
import com.feri.pay_api.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2019/5/8 15:01
 */
@Service
public class PrePaymentServiceImpl implements PrepaymentService {
    @Autowired
    private PrepaymentMapper prepaymentMapper;
    @Override
    public ResultVO save(Prepayment prepayment) {
        return ResultUtil.exec(prepaymentMapper.save(prepayment)>0,"操作结束",null);
    }

    @Override
    public ResultVO selectSingle(int id) {
        return ResultUtil.setOK("OK",prepaymentMapper.selectSingle(id));
    }

    @Override
    public ResultVO selectPage(int page, int count) {

        return ResultUtil.setOK(prepaymentMapper.selectCount()+"",prepaymentMapper.selectByPage((page-1)*count,count));
    }
}

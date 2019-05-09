package com.feri.pay_api.api;

import com.feri.pay_api.pay.dbservice.DbService;
import com.feri.pay_api.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/5/9 09:52
 */
@Api(value = "支付操作记录",tags = "支付操作记录")
@RestController
public class PayLog_Api {
    @Autowired
    private DbService dbService;
    @ApiOperation(value = "操作日志详情",notes = "操作日志详情")
    @GetMapping("/paylog/single.do")
    public ResultVO logsingle(int id){
       return dbService.getPaylogService().selectSingle(id);
    }
    @ApiOperation(value = "操作日志分页",notes = "操作日志分页")
    @GetMapping("/paylog/page.do")
    public ResultVO logpage(int page,int count){
        return dbService.getPaylogService().selectPage(page, count);
    }
    @ApiOperation(value = "支付二维码详情",notes = "支付二维码详情")
    @GetMapping("/payqrcode/single.do")
    public ResultVO codesingle(int id){
        return dbService.getPayrcodeService().selectSingle(id);
    }
    @ApiOperation(value = "支付二维码分页",notes = "支付二维码分页")
    @GetMapping("/payqrcode/page.do")
    public ResultVO codepage(int page,int count){
        return dbService.getPayrcodeService().selectPage(page, count);
    }
    @ApiOperation(value = "预支付信息详情",notes = "预支付信息详情")
    @GetMapping("/paypre/single.do")
    public ResultVO presingle(int id){
        return dbService.getPrepaymentService().selectSingle(id);
    }
    @ApiOperation(value = "预支付信息分页",notes = "预支付信息分页")
    @GetMapping("/paypre/page.do")
    public ResultVO prepage(int page,int count){
        return dbService.getPrepaymentService().selectPage(page, count);
    }
    @ApiOperation(value = "支付结果详情",notes = "支付结果详情")
    @GetMapping("/payresult/single.do")
    public ResultVO resultsingle(String oid){
        return dbService.getPayresultService().selectSingle(oid);
    }
    @ApiOperation(value = "支付结果分页",notes = "支付结果分页")
    @GetMapping("/payresult/page.do")
    public ResultVO resultpage(int page,int count){
        return dbService.getPayresultService().selectPage(page, count);
    }


}

package com.feri.pay_api.util;


import com.feri.pay_api.vo.ResultVO;

/**
 *@Author feri
 *@Date Created in 2019/4/28 17:28
 */
public class ResultUtil {
    public static ResultVO exec(boolean istrue, String msg, Object obj){
        ResultVO resultVO=new ResultVO(istrue?200:400,msg,obj);
        return resultVO;
    }
    public static ResultVO setOK(){
        return exec(true,"OK",null);
    }
    public static ResultVO setERROR(){
        return exec(false,"ERROR",null);
    }
    public static ResultVO setOK(String msg){
        return exec(true,msg,null);
    }
    public static ResultVO setOK(String msg,Object obj){
        return exec(true,msg,obj);
    }
}

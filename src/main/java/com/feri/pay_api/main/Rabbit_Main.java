package com.feri.pay_api.main;

/**
 *@Author feri
 *@Date Created in 2019/5/9 09:24
 */
public class Rabbit_Main {
    public static void main(String[] args) {
        for(int i=1;i<21;i++) {
            System.out.println(dg(i));
        }
    }
    public static long dg(int month){
        if(month<3){
            return 1;
        }else {
            return dg(month-1)+dg(month-2);
        }
    }
}
package com.bjsxt.test;

import com.bjsxt.biz.SxtUserBiz;

public class Client {
    public static void main(String[] args) {
        //只为用户提供主菜单
        SxtUserBiz sxt = new SxtUserBiz();
        sxt.mainMenu();
    }
}

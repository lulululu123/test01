package com.bjsxt.biz;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.entity.User;

import java.util.Scanner;

public class SxtUserBiz {
    private Scanner in= new Scanner(System.in);
    private UserDao userDao = new UserDaoImpl();//接口new实现类
    //系统主菜单
    public void mainMenu(){
        while(true){
            System.out.println("----------------------");
            System.out.println("1.注册   2.登陆    0.系统退出");
            System.out.println("----------------------");
            int choice = in.nextInt();
            switch (choice){
                case 0:
                    System.out.println("系统退出，谢谢你的使用");
                    break;
                case 1:
                    register();
                    continue;
                case 2:
                    login();
                    continue;
                default:
                    System.out.println("你输入的信息有误！");
                    continue;
            }
            break;

        }
    }

    private void register(){
        System.out.println("-------------注册");
        User user = getUser();//获取需要的用户对象
        //调用实现注册的功能
        boolean register = userDao.register(user);
        System.out.println(register?"注册成功":"用户名重复");
    }
    private void login(){
        System.out.println("------------登陆");
        User user = getUser();
        boolean login = userDao.login(user);
        System.out.println(login?"登陆成功":"对不起，用户名或密码不正确");
    }
    //因为注册和登陆都需用户对象
    private User getUser(){
        System.out.println("请输入用户名：");
        String uname = in.next();
        System.out.println("请输入密码：");
        int pwd = in.nextInt();
        return new User(uname,pwd);
    }
}



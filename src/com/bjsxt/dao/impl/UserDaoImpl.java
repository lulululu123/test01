package com.bjsxt.dao.impl;

import com.bjsxt.dao.UserDao;
import com.bjsxt.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static File file = new File("user.txt");
    private static List<User> a1 = new ArrayList<User>();
    //使用静态代码块为类的静态变量
    static{
        //文件不存在时执行
        if(!file.exists()){
            //初始化一个用户对象，存储到磁盘上
            User u = new User("admin",8888);
            a1.add(u);//将用户添加到集合当中
            write();//调用本类中的static方法，用于将数据写入磁盘文件【作为程序运行的必备数据】
        }
        //如果磁盘上文件存在，将从磁盘上读取数据，为程序的运行做准备
        read();//读取到的数据存放到集合当中
    }
    public static void read(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            a1 = (List<User>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void write(){
        //创建对象流对象，用于将集合对象存储到文件
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            //写对象，写集合
            oos.writeObject(a1);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean login(User user) {
        //遍历集合，如果数据在集合中存在，就登陆成功
        read();//先调用读取的方法，虫文件中读取数据
        for(User u:a1){
            if(u.getUname().equals(user.getUname())&&u.getPwd()==user.getPwd()){
             return true;
            }
        }
        return false;
    }

    private boolean checkUname(String uname){
        read();
        for(User u:a1){
            if(u.getUname().equals(uname)){
                return false;//用户名重复，不允许添加
            }
        }
        return true;
    }

    @Override
    public boolean register(User user) {
        //调用验证用户名是否重复的方法
        if(checkUname(user.getUname())){

            a1.add(user);//将数据添加到集合当中
            //重新写入文件
            write();//调用write（）方法
            return true;
        }else{
            return false;
        }
    }
}

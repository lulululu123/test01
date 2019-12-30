package com.bjsxt.dao;

import com.bjsxt.entity.User;

public interface UserDao {
    public boolean login(User user);//登陆
    public boolean register(User user);//注册
}

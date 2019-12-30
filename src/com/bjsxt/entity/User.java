package com.bjsxt.entity;

import java.io.Serializable;

public class User implements Serializable {
    private String uname;
    private int pwd;

    public User() {
    }

    public User(String uname, int pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}

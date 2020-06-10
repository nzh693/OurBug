package com.bug.entity;

/*
 *   Author = Liewona
 *   Date = 2020/6/9 15:01
 */

public class SignUser {

    private int identity;

    private String account;

    private String password;

    private String name;


    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

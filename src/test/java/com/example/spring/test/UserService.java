package com.example.spring.test;


public class UserService {
    /**
     * 添加一个user对象的实现，添加一个方法
     */
    public void queryUserInfo() {
        System.out.println("查询用户信息");
    }

    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ")
                .append(name);
        return sb.toString();
    }
}

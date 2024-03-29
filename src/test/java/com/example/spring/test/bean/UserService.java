package com.example.spring.test.bean;


import com.example.spring.test.bean.UserDao;

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

    //---------------------------------------------------------------------------
    private String uId;

    private UserDao userDao;

    public void queryUserInfo01() {

        System.out.println("查询用户信息");
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));

    }

    public String queryUserInfo02() {

        System.out.println("查询用户信息");
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
        return null;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //------------------
    private String company;
    private String location;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

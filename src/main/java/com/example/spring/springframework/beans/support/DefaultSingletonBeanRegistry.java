package com.example.spring.springframework.beans.support;

import com.example.spring.springframework.beans.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例函数的实现
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /**
     * 写一个Map,将单例添加的属性包装成一个HashMap
     */
    private static final Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 实现单例接口的方法
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 添加单例
     */
    protected void addSingleton(String beanName,Object singletonObject) {
        singletonObjects.put(beanName,singletonObject);
    }
    /**
     * 删除单例
     */
    protected void deleteSingleton(String beanName) {
        singletonObjects.remove(beanName);
    }

}

package com.example.spring.springframework.beans.config;

/**
 * 定义一个单例接口,
 * 有个问题，接口是怎么走的？？？？？？？？？？？？？重要
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String name);
}

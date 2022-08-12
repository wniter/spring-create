package com.example.spring.springframework.beans.factory;

import com.example.spring.springframework.beans.exception.BeansException;

/**
 * 定义一个BeanFactory接口
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
}

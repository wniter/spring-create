package com.example.spring.springframework.beans.support;

import com.example.spring.springframework.beans.config.BeanDefinition;
import com.example.spring.springframework.beans.exception.BeansException;

import java.lang.reflect.Constructor;

/**
 * bean实例化的策略：
 * CglibSubclassingInstantiationStrategy
 * SimpleInstantiationStrategy
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}

package com.example.spring.springframework.beans.config;

import com.example.spring.springframework.beans.exception.BeansException;

/**
 * 用于修改实例化 Bean 对象的扩展点
 */
public interface BeanPostProcessor {
    /**
     * 在 Bean 对象执行初始化方法前，执行
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在Bean对象执行出事化后，执行
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}

package com.example.spring.springframework.beans.support;

import com.example.spring.springframework.beans.config.BeanDefinition;

/**
 * 向注册表中注册BeanDefinition接口
 */
public interface BeanDefinitionRegistry {

    void  registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}

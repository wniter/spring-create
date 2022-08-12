package com.example.spring.springframework.beans.support;

import com.example.spring.springframework.beans.config.BeanDefinition;
import com.example.spring.springframework.beans.exception.BeansException;
import com.example.spring.springframework.beans.factory.BeanFactory;

/**
 * BeanFactory的抽象类，用于函数的具体实现
 */
public abstract class AbstractBeanFactory extends  DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if ( bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);

        return createBean(name,beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws  BeansException;

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;


}

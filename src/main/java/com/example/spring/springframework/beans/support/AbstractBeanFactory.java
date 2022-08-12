package com.example.spring.springframework.beans.support;

import com.example.spring.springframework.beans.config.BeanDefinition;
import com.example.spring.springframework.beans.exception.BeansException;
import com.example.spring.springframework.beans.factory.BeanFactory;

/**
 * BeanFactory的抽象类，用于函数的具体实现
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
//        Object bean = getSingleton(name);
//        if ( bean != null) {
//            return bean;
//        }
//        BeanDefinition beanDefinition = getBeanDefinition(name);
//
//        return createBean(name,beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    /**
     * 多个bean的实现
     */
    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }


    /**
     * 把bean的多个和一个抽取出来做成一个doGetBean的实现，做成一个泛型
     *
     * @param name
     * @param args
     * @return
     */
    protected <T> T doGetBean(String name, Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);

        return (T) createBean(name, beanDefinition,args);
    }


}

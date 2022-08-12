package com.example.spring.springframework.beans.factory;

import com.example.spring.springframework.beans.exception.BeansException;

/**
 * 定义一个BeanFactory接口
 */
public interface BeanFactory {

    /**
     * 单走一个getBean
     *
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 多个getBean
     * Object... args 相当于Object[] args，在参数上有所不同，为可变长度参数
     *
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;
}

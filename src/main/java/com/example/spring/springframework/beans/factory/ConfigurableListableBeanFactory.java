package com.example.spring.springframework.beans.factory;

import com.example.spring.springframework.beans.config.AutowireCapableBeanFactory;
import com.example.spring.springframework.beans.config.BeanDefinition;
import com.example.spring.springframework.beans.config.ConfigurableBeanFactory;
import com.example.spring.springframework.beans.exception.BeansException;


public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
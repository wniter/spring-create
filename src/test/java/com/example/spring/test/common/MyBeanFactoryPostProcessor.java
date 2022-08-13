package com.example.spring.test.common;


import com.example.spring.springframework.beans.PropertyValue;
import com.example.spring.springframework.beans.PropertyValues;
import com.example.spring.springframework.beans.config.BeanDefinition;
import com.example.spring.springframework.beans.config.BeanFactoryPostProcessor;
import com.example.spring.springframework.beans.exception.BeansException;
import com.example.spring.springframework.beans.factory.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}

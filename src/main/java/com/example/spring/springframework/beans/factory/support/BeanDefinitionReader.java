package com.example.spring.springframework.beans.factory.support;

import com.example.spring.springframework.beans.BeansException;
import com.example.spring.springframework.core.io.Resource;
import com.example.spring.springframework.core.io.ResourceLoader;

/**
 * Simple interface for bean definition readers.
 *
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

}

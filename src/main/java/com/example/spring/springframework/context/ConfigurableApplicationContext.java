package com.example.spring.springframework.context;

import com.example.spring.springframework.beans.exception.BeansException;

/**
 * ApplicationContext的配置接口
 */
public interface ConfigurableApplicationContext extends ApplicationContext{
    /**
     * 刷新容器
     */
    void refresh() throws BeansException;
}

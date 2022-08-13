package com.example.spring.springframework.context.support;

import com.example.spring.springframework.beans.support.DefaultListableBeanFactory;
import com.example.spring.springframework.beans.xml.XmlBeanDefinitionReader;

/**
 * 抽象类 xml的application 的上下文
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}

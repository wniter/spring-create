package com.example.spring.springframework.beans.support;

import com.example.spring.springframework.beans.config.SingletonBeanRegistry;
import com.example.spring.springframework.beans.exception.BeansException;
import com.example.spring.springframework.beans.factory.DisposableBean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 单例函数的实现
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /**
     * 写一个Map,将单例添加的属性包装成一个HashMap
     */
    private static final Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 写一个DisposableBean放入HashMap
     */

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    /**
     * 实现单例接口的方法
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 添加单例
     */
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    /**
     * 删除单例
     */
    protected void deleteSingleton(String beanName) {
        singletonObjects.remove(beanName);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    /**
     * 销毁的单例实现
     */
    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object BeanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(BeanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + BeanName + "' threw an exception", e);
            }
        }
    }
}

package com.example.spring.springframework.beans.support;

import com.example.spring.springframework.beans.config.BeanDefinition;
import com.example.spring.springframework.beans.exception.BeansException;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import java.lang.reflect.Constructor;

/**
 * cglib策略实现
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{




    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor){
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(),args);
    }
}

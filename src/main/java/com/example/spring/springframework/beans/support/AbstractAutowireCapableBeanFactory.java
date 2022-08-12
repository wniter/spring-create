package com.example.spring.springframework.beans.support;

import cn.hutool.core.bean.BeanUtil;
import com.example.spring.springframework.beans.PropertyValue;
import com.example.spring.springframework.beans.PropertyValues;
import com.example.spring.springframework.beans.config.BeanDefinition;
import com.example.spring.springframework.beans.config.BeanReference;
import com.example.spring.springframework.beans.exception.BeansException;


import java.lang.reflect.Constructor;

/**
 * AbstractBeanFactory的自动装配，对AbstractBeanFactory的实现
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    /**
     * 实现createBean
     *
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
//            bean = beanDefinition.getBeanClass().newInstance();
//            把这个地方封装一下,多加了一个args参数属性
            bean = createBeanInstance(beanDefinition, beanName, args);


            //填充bean的属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }


    //这个地方要写注释
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {

        Constructor constructorToUse = null;

        Class<?> beanClass = beanDefinition.getBeanClass();

        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();

        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterAnnotations().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }


    /**
     * 填充bean的属性
     *
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();


            //     1.1，数组既可以存储基本数据类型,又可以存储引用数据类型,基本数据类型存储的是值,引用数据类型存储的是地址值
            //     1.2，集合只能存储引用数据类型(对象)集合中也可以存储基本数据类型,但是在存储的时候会自动装箱变成对象
//            长度的区别:
//            2.1，数组长度是固定的,不能自动增长
//            2.2，集合的长度的是可变的,可以根据元素的增加而增长
//            使用选择
//            3.1，果元素个数是固定的推荐用数组
//            3.2，如果元素个数不是固定的推荐用集合
            for (PropertyValue propertyValue : propertyValues.getPropertyValueList()) {
//            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }


}

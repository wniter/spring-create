package com.example.spring.springframework.beans.config;


import com.example.spring.springframework.beans.PropertyValues;

/**
 * bean的定义
 */
public class BeanDefinition {
    /**
     * 定义一个beanClass对象，返回Class类
     * 对象定义为class类的作用
     * 1.Class类是Java 反射机制的起源和入口，用于获取与类相关的各种信息，提供了获取类信息的相关方法。Class类继承自Object类
     * 2.能够通过相应方法取出相应信息：类的名字、属性、方法、构造方法、父类和接口
     */
    private Class beanClass;


    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        ////加入bean的引用
        this.propertyValues = new PropertyValues();
    }


    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    //--------------------------------------------------
    //加入bean的引用
    private PropertyValues propertyValues;


    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    //------------------

    private String initMethodName;

    private String destroyMethodName;

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}

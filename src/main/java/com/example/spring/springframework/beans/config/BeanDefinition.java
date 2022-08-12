package com.example.spring.springframework.beans.config;

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

    public  BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }
    public Class getBeanClass() {
        return beanClass;
    }
    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

}

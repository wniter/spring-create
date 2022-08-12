package com.example.spring.springframework.beans;

import com.example.spring.springframework.beans.exception.BeansException;

import java.util.ArrayList;
import java.util.List;

/**
 * bean的属性list集合信息
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    /**
     * 添加PropertyValue属性
     */
    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    /**
     * 获得PropertyValues
     *
     * @return PropertyValue数组
     */
    public PropertyValue[] getPropertyValues() {
        if (propertyValueList == null && propertyValueList.isEmpty()) {
            throw new BeansException("this is propertyValueList is null");
        } else {
            return this.propertyValueList.toArray(new PropertyValue[0]);
        }

    }

    /**
     * 获得PropertyValue
     *
     * @param propertyName
     * @return
     */
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }

    /**
     * 直接返回propertyValueList
     * 有问题，如果没有add,这个集合就是空的
     *
     * @return
     */
    public List<PropertyValue> getPropertyValueList() {
        if (propertyValueList == null && propertyValueList.isEmpty()) {
            throw new BeansException("this is propertyValueList is null");
        } else {
            return this.propertyValueList;
        }
    }
}

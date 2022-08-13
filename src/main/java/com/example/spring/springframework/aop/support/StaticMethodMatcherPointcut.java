package com.example.spring.springframework.aop.support;


import com.example.spring.springframework.aop.ClassFilter;
import com.example.spring.springframework.aop.MethodMatcher;
import com.example.spring.springframework.aop.Pointcut;

/**
 * @author zhangdd on 2022/2/27
 */
public abstract class StaticMethodMatcherPointcut extends StaticMethodMatcher implements Pointcut {

    private ClassFilter classFilter = ClassFilter.TRUE;

    public void setClassFilter(ClassFilter classFilter) {
        this.classFilter = classFilter;
    }

    public ClassFilter getClassFilter() {
        return classFilter;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}

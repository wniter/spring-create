package com.example.spring.springframework.jdbc.support;


import com.example.spring.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;

/**
 * @author zhangdd on 2022/2/9
 */
public abstract class JdbcAccessor implements InitializingBean {

    private DataSource dataSource;


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected DataSource obtainDataSource() {
        return getDataSource();
    }

    @Override
    public void afterPropertiesSet() {
        if (null == getDataSource()) {
            throw new IllegalArgumentException("Property 'datasource' is required");
        }
    }
}

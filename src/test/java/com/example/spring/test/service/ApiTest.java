package com.example.spring.test.service;


import com.example.spring.springframework.aop.AdvisedSupport;
import com.example.spring.springframework.aop.TargetSource;
import com.example.spring.springframework.aop.framework.Cglib2AopProxy;
import com.example.spring.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.spring.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.example.spring.springframework.jdbc.support.JdbcTemplate;
import com.example.spring.springframework.test.service.impl.JdbcServiceImpl;
import com.example.spring.springframework.tx.transaction.annotation.AnnotationTransactionAttributeSource;
import com.example.spring.springframework.tx.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor;
import com.example.spring.springframework.tx.transaction.interceptor.TransactionAttribute;
import com.example.spring.springframework.tx.transaction.interceptor.TransactionInterceptor;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.lang.reflect.Method;

/**
 * @author zhangdd on 2022/1/28
 */
public class ApiTest {

    private JdbcTemplate jdbcTemplate;

//    private JdbcService jdbcService;

    private DataSource dataSource;

    @Before
    public void init() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        dataSource = applicationContext.getBean(DruidDataSource.class);

//        jdbcService = applicationContext.getBean(JdbcServiceImpl.class);
    }

    @Test
    public void matchTransactionAnnotationTest() {
        JdbcService jdbcService = new JdbcServiceImpl();
        AnnotationTransactionAttributeSource transactionAttributeSource = new AnnotationTransactionAttributeSource();
        Method[] methods = jdbcService.getClass().getMethods();
        Method targetMethod = null;
        for (Method method : methods) {
            if (method.getName().equals("saveData")) {
                targetMethod = method;
                break;
            }
        }
        TransactionAttribute transactionAttribute = transactionAttributeSource.getTransactionAttribute(targetMethod, jdbcService.getClass());
        System.out.println(transactionAttribute.getName());
    }

    @Test
    public void jdbcWithTransaction() {

        JdbcService jdbcService = new JdbcServiceImpl();

        AnnotationTransactionAttributeSource transactionAttributeSource = new AnnotationTransactionAttributeSource();
        transactionAttributeSource.findTransactionAttribute(jdbcService.getClass());


        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        TransactionInterceptor interceptor = new TransactionInterceptor(transactionManager, transactionAttributeSource);

        BeanFactoryTransactionAttributeSourceAdvisor btas = new BeanFactoryTransactionAttributeSourceAdvisor();
        btas.setAdvice(interceptor);


        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(jdbcService));
        advisedSupport.setMethodInterceptor(interceptor);
        advisedSupport.setMethodMatcher(btas.getPointcut().getMethodMatcher());
        advisedSupport.setProxyTargetClass(false);

        JdbcService proxyCglib = (JdbcServiceImpl) new Cglib2AopProxy(advisedSupport).getProxy();


        proxyCglib.saveData(jdbcTemplate);
    }


}


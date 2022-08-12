package com.example.spring;
//
//import com.example.spring.springframework.BeanDefinition;
//import com.example.spring.springframework.BeanFactory;
import com.example.spring.springframework.beans.config.BeanDefinition;
import com.example.spring.springframework.beans.support.DefaultListableBeanFactory;
import com.example.spring.test.UserService;
import org.junit.jupiter.api.Test;

public class ApiTest {

//    private  final String userservice = "userService";
//
//    /**
//     * 测试一个beanfactory是否获取到bean对象
//     */
//    @Test
//    public void test_BeanFactory() {
//
//        //1-初始化 BeanFactory
//        BeanFactory beanFactory = new BeanFactory();
//
//        //2-注入bean
//        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
//        beanFactory.registerBeanDefinition(userservice, beanDefinition);
//
//        //3-获取bean
//        UserService userService = (UserService) beanFactory.getBean(userservice);
//        userService.queryUserInfo();
//    }

    @Test
    public void test_BeanFactory_01(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
        userService_singleton.queryUserInfo();
    }

}

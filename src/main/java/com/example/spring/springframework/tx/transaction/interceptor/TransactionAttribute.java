package com.example.spring.springframework.tx.transaction.interceptor;


import com.example.spring.springframework.tx.transaction.TransactionDefinition;

/**
 * @author zhangdd on 2022/2/26
 */
public interface TransactionAttribute extends TransactionDefinition {

    boolean rollbackOn(Throwable ex);
}

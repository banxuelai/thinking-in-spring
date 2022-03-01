package org.geekbang.thinking.in.spring.bean.factory;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * {@link UserFactory}
 * @author bxl
 * @date 2022/2/22
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

    // 1. 基于PostConstruct注解
    @PostConstruct
    public void init() {
        System.out.println("UserFactory 初始化中....");
    }

    public void initUserFactory() {
        System.out.println("initUserFactory 初始化中....");
    }

    @Override
    public void  afterPropertiesSet() throws Exception{
        System.out.println("InitializingBean#afterPropertiesSet() 初始化中....");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("UserFactory @PreDestroy 销毁中....");
    }

    @Override
    public  void destroy() throws Exception {
        System.out.println("DisposableBean#destroy()  销毁中....");
    }

    public void doDestroy() {
        System.out.println("自定义方法 doDestroy 销毁中....");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前对象DefaultUserFactory正在被回收....");
    }
}

package org.geekbang.thinking.in.spring.bean.factory;


import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * {@link UserFactory}
 * @author bxl
 * @date 2022/2/22
 */
public class DefaultUserFactory implements UserFactory, InitializingBean {

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
        System.out.println("InitializingBean 初始化中....");
    }
}

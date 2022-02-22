package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean 实例化
 * @author bxl
 * @date 2022/2/22
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        User user = beanFactory.getBean("user-by-static-method", User.class);
        User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);

        User userByFactoryBean = beanFactory.getBean("user-by-factory", User.class);

        System.out.println(userByInstanceMethod);
        System.out.println(user);
        System.out.println(userByFactoryBean);
    }
}

package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.geekbang.thinking.in.spring.bean.factory.UserFactory;
import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean 实例化
 * @author bxl
 * @date 2022/2/22
 */
@Configuration
public class BeanInstantiationDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        User user = beanFactory.getBean("user-by-static-method", User.class);
        User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);

        User userByFactoryBean = beanFactory.getBean("user-by-factory", User.class);

        System.out.println(userByInstanceMethod);
        System.out.println(user);
        System.out.println(userByFactoryBean);

        // 创建beanFactory容器
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();

        // 注册bean
        applicationContext.register(BeanInstantiationDemo.class);
        // 启动应用上下文
        applicationContext.refresh();

        // 非延迟初始化在Spring应用上下文启动完成后被初始化
        System.out.println("Spring应用上下文已完成启动");

        // 依赖查找
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);

        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean(initMethod = "initUserFactory")
    @Lazy
    public UserFactory userFactory () {
        return new DefaultUserFactory();
    }
}

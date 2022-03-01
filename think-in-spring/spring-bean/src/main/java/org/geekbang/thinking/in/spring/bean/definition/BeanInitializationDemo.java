package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.geekbang.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author bxl
 * @date 2022/3/1
 */
@Configuration
public class BeanInitializationDemo {

    public static void main(String[] args) {

        // 创建beanFactory容器
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();
        // 注册bean
        applicationContext.register(BeanInitializationDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        // 非延迟初始化在Spring应用上下文启动完成后被初始化
        System.out.println("Spring应用上下文已完成启动");

        // 依赖查找
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);

        System.out.println("Spring应用上下文准备关闭");

        // 关闭应用上下文
        applicationContext.close();

        System.out.println("Spring应用上下文已关闭");
    }

    @Bean(initMethod = "initUserFactory", destroyMethod = "doDestroy")
    public UserFactory userFactory () {
        return new DefaultUserFactory();
    }
}

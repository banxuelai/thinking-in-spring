package org.geekbang.thinking.in.springioc.overview.dependency.injection;

import org.geekbang.thinking.in.springioc.overview.domain.SuperUser;
import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.geekbang.thinking.in.springioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入示例
 * @author bxl
 * @date 2020/8/21
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {

        // 配置 xml配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
//        User user = (User)beanFactory.getBean("user");
//        System.out.print(user);
//
//        SuperUser superUser = (SuperUser)beanFactory.getBean("superUser");
//        System.out.print(superUser);

        // 依赖来源一：自定义bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        //System.out.println(userRepository);

        // 依赖来源二：依赖注入 （内建依赖）
        System.out.println(userRepository.getBeanFactory());

        ObjectFactory userObjectFactory = userRepository.getObjectFactory();
        //System.out.println(userObjectFactory.getObject() == beanFactory);

        // 依赖查找（错误）
        //System.out.println(beanFactory.getBean(BeanFactory.class));

        // 依赖来源三：容器内置bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取Environment 类型的bean:" + environment);
    }

    private static void whoIsIocContainer(UserRepository userRepository, BeanFactory beanFactory) {

        // 为什么这个表达式不成立
        System.out.println(userRepository.getBeanFactory() == beanFactory);

        // ApplicationContext is BeanFactory
    }
}

package org.geekbang.thinking.in.springioc.overview.dependency.injection;

import org.geekbang.thinking.in.springioc.overview.domain.SuperUser;
import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.geekbang.thinking.in.springioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

//        User user = (User)beanFactory.getBean("user");
//        System.out.print(user);
//
//        SuperUser superUser = (SuperUser)beanFactory.getBean("superUser");
//        System.out.print(superUser);

        UserRepository userRepository = (UserRepository)beanFactory.getBean("userRepository", UserRepository.class);
        //System.out.println(userRepository);

        ObjectFactory userObjectFactory = userRepository.getObjectFactory();

        System.out.println(userRepository.getBeanFactory());
        System.out.println(userObjectFactory.getObject() == beanFactory);
    }
}

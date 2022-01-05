package org.geekbang.thinking.in.springioc.overview.dependency.lookup;

import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author banxuelai001
 * @date 2020/8/21
 */
public class DependencyLookUpDemo {

    public static void main(String[] args) {

        // 配置 xml配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        User user = (User)beanFactory.getBean("user");
        System.out.print(user);
    }
}

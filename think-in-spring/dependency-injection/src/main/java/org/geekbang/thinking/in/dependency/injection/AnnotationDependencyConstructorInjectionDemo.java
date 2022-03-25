package org.geekbang.thinking.in.dependency.injection;

import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 通过java注解 依赖注入实现
 * @author bxl
 * @date 2022/3/23
 */
public class AnnotationDependencyConstructorInjectionDemo {

    public static void main(String[] args) {

        // 创建beanFactory容器
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();

        // 1. 通过@Bean 方式定义
        applicationContext.register(AnnotationDependencyConstructorInjectionDemo.class);


        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.print(userHolder);

        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public  UserHolder userHolder(User user) {

        return new UserHolder(user);
    }
}

package org.geekbang.thinking.in.dependency.injection;

import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 通过java注解 依赖字段注入实现
 * @author bxl
 * @date 2022/3/23
 */
public class AnnotationDependencyMethodInjectionDemo {

    private UserHolder userHolder1;

    private UserHolder userHolder2;

    @Autowired
    public void initUserHolder1(UserHolder userHolder1) {
        this.userHolder1 = userHolder1;
    }

    @Resource
    public void initUserHolder2(UserHolder userHolder2) {
        this.userHolder2 = userHolder2;
    }

    public static void main(String[] args) {

        // 创建beanFactory容器
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();

        // 1. 通过@Bean 方式定义
        applicationContext.register(AnnotationDependencyMethodInjectionDemo.class);


        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动spring应用上下文
        applicationContext.refresh();

        AnnotationDependencyMethodInjectionDemo demo = applicationContext.getBean(AnnotationDependencyMethodInjectionDemo.class);

        // Autowired字段关联
        UserHolder userHolder = demo.userHolder1;
        System.out.print(userHolder);

        UserHolder userHolderTwo = demo.userHolder2;
        System.out.print(userHolderTwo);

        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public  UserHolder userHolder(User user) {

        return new UserHolder(user);
    }
}

package org.geekbang.thinking.in.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 通过 {@link org.springframework.beans.factory.ObjectProvider} 实现依赖查找
 * @author bxl
 * @date 2022/3/3
 */
public class ObjectProviderDemo { // @Configuration 是非必须的注解

    public static void main(String[] args) {

        // 创建beanFactory容器
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();
        // 注册bean
        applicationContext.register(ObjectProviderDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        // 依赖查找
        lookupByObjectProvider(applicationContext);

        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public String helloWorld() { // 方法名就是 bean名称 "helloWorld"
        return "hello, world";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {

        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);

        System.out.println(objectProvider.getObject());
    }
}

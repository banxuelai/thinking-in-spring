package org.geekbang.thinking.in.dependency.lookup;

import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;


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

        lookupIfAvailable(applicationContext);
        lookupByStreamOps(applicationContext);

        // 关闭应用上下文
        applicationContext.close();
    }

    private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);

        objectProvider.stream().forEach(System.out::println);
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> objectProvider = applicationContext.getBeanProvider(User.class);

        User user = objectProvider.getIfAvailable(() -> User.createUser());

        System.out.println("当前 User 对象" + user);
    }

    @Bean
    @Primary
    public String helloWorld() { // 方法名就是 bean名称 "helloWorld"
        return "hello, world";
    }

    @Bean
    public String message() {
        return "message";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {

        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);

        System.out.println(objectProvider.getObject());
    }
}
